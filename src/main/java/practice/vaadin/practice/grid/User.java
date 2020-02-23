package practice.vaadin.practice.grid;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private LocalDate registrationDate;

}
