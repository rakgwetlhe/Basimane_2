package Utils;

public class UserRepository {

    private final String email;
    private final String password;

    public UserRepository(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /** Safe toString — never prints the password. */
    @Override
    public String toString() {
        return "UserRepository{email='" + email + "'}";
    }
}