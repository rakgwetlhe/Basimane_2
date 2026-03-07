package Utils;

public class DBConfig {

    public static final String URL      = "jdbc:mysql://102.222.124.22:3306/ndosian6b8b7_teaching";
    public static final String USERNAME = "ndosian6b8b7_teaching";
    public static final String PASSWORD = "^{SF0a=#~[~p)@l1";

    // The email address of the pre-existing admin account in the database.
    // Used by Scenario 2 to log in as admin and approve the new user.
    // Replace this with the actual admin email that exists in your DB.
    public static final String ADMIN_EMAIL = "admin@gmail.com";

    private DBConfig() {} // utility class — no instances
}
