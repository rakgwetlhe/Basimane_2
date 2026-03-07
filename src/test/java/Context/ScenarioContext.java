package Context;

import Utils.UserRepository;

public class ScenarioContext {

    private UserRepository currentUser;

    // ── Current-user accessors ────────────────────────────────────────────────

    public void setCurrentUser(UserRepository user) {
        this.currentUser = user;
    }

    public UserRepository getCurrentUser() {
        return currentUser;
    }

    // ── Convenience accessors (delegates to currentUser) ─────────────────────

    /** Stores the email by wrapping it in a UserRepository, preserving any existing password. */
    public void setEmail(String email) {
        String existingPassword = (currentUser != null) ? currentUser.getPassword() : null;
        this.currentUser = new UserRepository(email, existingPassword);
    }

    public String getEmail() {
        return (currentUser != null) ? currentUser.getEmail() : null;
    }

    /** Stores the password by wrapping it in a UserRepository, preserving any existing email. */
    public void setPassword(String password) {
        String existingEmail = (currentUser != null) ? currentUser.getEmail() : null;
        this.currentUser = new UserRepository(existingEmail, password);
    }

    public String getPassword() {
        return (currentUser != null) ? currentUser.getPassword() : null;
    }

    // ── Lifecycle ─────────────────────────────────────────────────────────────

    /** Clears all stored state. Called from the global @Before hook. */
    public void reset() {
        this.currentUser = null;
    }
}