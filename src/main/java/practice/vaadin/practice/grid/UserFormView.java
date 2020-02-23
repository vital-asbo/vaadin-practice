package practice.vaadin.practice.grid;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


public class UserFormView extends VerticalLayout implements View {

    private User user;

    public UserFormView() {
        Button returnButton = new Button("Menu", event -> {
            getUI().getNavigator().navigateTo("");
        });
        addComponent(returnButton);
        setComponentAlignment(returnButton, Alignment.TOP_CENTER);
        setWidth("100%");
        setHeightUndefined();
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setCaption("User Form");
        addComponent(createFormLayout());
    }

    public FormLayout createFormLayout() {
        setDefaultComponentAlignment(Alignment.TOP_CENTER);

        FormLayout userForm = new FormLayout();
        userForm.setSizeUndefined();
        addComponent(userForm);

        TextField tf1 = new TextField("Login");
        tf1.setIcon(VaadinIcons.USER);
//        tf1.setRequiredIndicatorVisible(true);
        userForm.addComponent(tf1);

        PasswordField passwordField = new PasswordField("Password");
        passwordField.setIcon(VaadinIcons.PASSWORD);
        userForm.addComponent(passwordField);

        TextField tf2 = new TextField("Email");
        tf2.setIcon(VaadinIcons.MAILBOX);
        userForm.addComponent(tf2);

        DateField dateField = new DateField("Date");
        dateField.setIcon(VaadinIcons.CALENDAR);
        userForm.addComponent(dateField);

        if (user != null) {
            tf1.setValue(user.getLogin());
            passwordField.setValue(user.getPassword());
            tf2.setValue(user.getEmail());
            dateField.setValue(user.getRegistrationDate());
        }

        Button saveButton = new Button("Save");
        saveButton.setIcon(VaadinIcons.DATABASE);
        userForm.addComponent(saveButton);

        UserData userData = new UserData();

        saveButton.addClickListener(event -> {
            if (user == null) {
                User user = new User(userData.getUserList().size() + 1, tf1.getValue(), passwordField.getValue(), tf2.getValue(), dateField.getValue());
                userData.addUser(user);
                Notification.show("New User has been added: " + user);
            } else {
                user.setLogin(tf1.getValue());
                user.setPassword(passwordField.getValue());
                user.setEmail(tf2.getValue());
                user.setRegistrationDate(dateField.getValue());
                userData.updateUser(user);
                Notification.show("The user has been updated: " + user);
            }
        });
        return userForm;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome to the User Form");
    }
}

