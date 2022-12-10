package Frontend;

public class User {
    private String name;
    private String username;

    public User() {

    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public static void main(String args[]) {
        User u = new User();
    }
}
