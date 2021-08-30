package pojo;

public class ExistingUserAccount {
    private String userEmail;

    public ExistingUserAccount(String _userEmail) {
        this.userEmail = _userEmail;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
