package Utils;

public class UserRepository {

    private String email;
    private String password;

    public UserRepository(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}