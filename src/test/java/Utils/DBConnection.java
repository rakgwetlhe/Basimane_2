package Utils;

import java.sql.*;

public class DBConnection {

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                DBConfig.URL,
                DBConfig.USERNAME,
                DBConfig.PASSWORD
        );
    }

    /** Retrieves credentials for a user by their numeric ID. */
    public UserRepository getUserCredentials(int userId) {
        String query = "SELECT email, password FROM login_user WHERE id = ?";

        try (Connection connect = openConnection();
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new UserRepository(rs.getString("email"), rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }
        return null;
    }

    /** Retrieves credentials for a user by their email address. */
    public UserRepository getUserCredentialsByEmail(String email) {
        String query = "SELECT email, password FROM login_user WHERE email = ? LIMIT 1";

        try (Connection connect = openConnection();
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new UserRepository(rs.getString("email"), rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }
        return null;
    }

    /**
     * FIX: login_user has no role column — role is managed by the application layer.
     * The promoted admin is identified by email stored in ScenarioContext during the
     * registration + promotion scenario that ran before this one.
     * This method now fetches by the email stored in ScenarioContext (passed in as param),
     * falling back to DBConfig.ADMIN_EMAIL if none is available.
     */
    public UserRepository getLatestPromotedAdminCredentials(String promotedEmail) {
        String emailToUse = (promotedEmail != null && !promotedEmail.isEmpty())
                ? promotedEmail
                : DBConfig.ADMIN_EMAIL;

        System.out.println("[DBConnection] Fetching promoted admin by email: " + emailToUse);
        return getUserCredentialsByEmail(emailToUse);
    }

    /**
     * Fetches the pre-existing admin account by email (DBConfig.ADMIN_EMAIL).
     * Used by Scenario 2 to log in as admin and approve the new user.
     */
    public UserRepository getAdminCredentials() {
        System.out.println("[DBConnection] Fetching admin credentials for: " + DBConfig.ADMIN_EMAIL);
        return getUserCredentialsByEmail(DBConfig.ADMIN_EMAIL);
    }
}
