package code;
import java.util.List;
public interface UsersDAOInterface {
    void createUsers(Users users);
    List<Users> listUsers();
    Users listUsersByID(int ID);
    void updateUsers(int ID, String name, String email, String password);

    void deleteUsers(int ID);
}
