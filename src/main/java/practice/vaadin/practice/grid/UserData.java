package practice.vaadin.practice.grid;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public List <User> getUserList(){
        List<User> users = new ArrayList<>();
        users.add((new User (0, "0login","pass0","zero@email.com")));
        users.add((new User (1, "1login","pass1","one@email.com")));
        users.add((new User (2, "2login","pass2","two@email.com")));
        users.add((new User (3, "3login","pass3","three@email.com")));

        return users;
    }
}
