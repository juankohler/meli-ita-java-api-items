public class User {

    public String userName;

    public String token;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{"+
               "name=" + userName + '\'' +
               "token=" + token + '\'' +
               '}';
    }
}
