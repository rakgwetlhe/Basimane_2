package Utils;

import java.sql.*;

public class DBConnection {

    private final String dbUrl = "jdbc:mysql://102.222.124.22:3306/ndosian6b8b7_teaching";
    private final String dbUsername = "ndosian6b8b7_teaching";
    private final String dbPassword = "^{SF0a=#~[~p)@l1";

    public String[] getUserCredentials(int userId) {

        String query = "SELECT email, password FROM login_user WHERE id = ?";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                return new String[]{email, password};
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }

    // Fetch credentials by email - useful when you know the user's email
    public String[] getUserCredentialsByEmail(String email) {
        String query = "SELECT email, password FROM login_user WHERE email = ? LIMIT 1";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String foundEmail = resultSet.getString("email");
                String password = resultSet.getString("password");

                return new String[]{foundEmail, password};
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }

    // Best-effort: fetch the most recently promoted user with role 'Admin'
    // Assumption: there's a column named 'role' in login_user that stores roles like 'Admin'.
    public String[] getLatestPromotedAdminCredentials() {
        String query = "SELECT email, password FROM login_user WHERE role = 'Admin' ORDER BY id DESC LIMIT 1";

        try (Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connect.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                return new String[]{email, password};
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }

        return null;
    }
}
