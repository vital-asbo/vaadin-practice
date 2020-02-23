package practice.vaadin.practice.grid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserData {

    private static List<User> users;

    public List<User> getUserList() {
        if (users == null) {
            users = new ArrayList<>();
            users.add((new User(0, "0login", "pass0", "zero@email.com", LocalDate.of(2016, 11, 9))));
            users.add((new User(1, "1login", "pass1", "one@email.com",LocalDate.of(2016, 12, 10))));
            users.add((new User(2, "2login", "pass2", "two@email.com", LocalDate.of(2017, 2, 1))));
            users.add((new User(3, "3login", "pass3", "three@email.com", LocalDate.of(2017, 12, 15))));
        }
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(User user){
        User userTemp = getUserById(user.getId());
        userTemp.setEmail(user.getEmail());
        userTemp.setPassword(user.getPassword());
        userTemp.setLogin(user.getLogin());
    }

    private User getUserById(int id){
        return users.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}
