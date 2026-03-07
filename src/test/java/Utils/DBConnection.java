package Utils;

import java.sql.*;

public class DBConnection {

    private final String dbUrl = "jdbc:mysql://102.222.124.22:3306/ndosian6b8b7_teaching";
    private final String dbUsername = "ndosian6b8b7_teaching";
    private final String dbPassword = "^{SF0a=#~[~p)@l1";

    /** Retrieves credentials for a user by their numeric ID. */
    public UserRepository getUserCredentials(int userId) {
        String query = "SELECT email, password FROM login_user WHERE id = ?";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new UserRepository(
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }

    /** Retrieves credentials for a user by their email address. */
    public UserRepository getUserCredentialsByEmail(String email) {
        String query = "SELECT email, password FROM login_user WHERE email = ? LIMIT 1";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new UserRepository(
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }

    /** Fetches credentials for the most recently promoted Admin user. */
    public UserRepository getLatestPromotedAdminCredentials() {
        String query = "SELECT email, password FROM login_user WHERE role = 'Admin' ORDER BY id DESC LIMIT 1";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new UserRepository(
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }
}

