package code;

public class Users implements UsersInterface{
    private int ID;
    private String name;
    private String email;
    private String password;

    public Users(int ID, String name, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //Getter
    @Override
    public int getID() {
        return ID;
    }

    //Setter
    public void setID(int ID) {
        this.ID = ID;
    }

    //Getter
    @Override
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    //Getter
    @Override
    public String getEmail() {
        return email;
    }

    //Setter
    public void setEmail(String email) {
        this.email = email;
    }

    //Getter
    @Override
    public String getPassword() {
        return password;
    }

    //Setter
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("[ID : %s | Name : %s | Email : %s | Password : %s ]");
    }

}
