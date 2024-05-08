package model;

public class User {

    private String username;

   private UserData userData;

    public User() {
    }

    public User(String username, UserData userData) {
        this.username = username;
        this.userData = userData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userData=" + userData +
                '}';
    }
}
