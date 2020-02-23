package practice.vaadin.practice.grid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.List;

public class UserGridView extends GridLayout implements View {
    private List<User> userList;

    private boolean getUserList() {
        UserData userData = new UserData();
        userList = userData.getUserList();
        return userList != null;
    }

    public UserGridView() {
        if (!getUserList()) {
            addComponent(new Label("No Data"));
            return;
        }

        Grid<User> grid = new Grid();
        setSizeFull();
        grid.setSizeFull();
        grid.setItems(userList);

        grid.addColumn(User::getLogin).setCaption("Login");
        grid.addColumn(User::getEmail).setCaption("Email");

        addComponent(grid);
        grid.addItemClickListener(item -> {
            if (item.getMouseEventDetails().isDoubleClick()) {
                Window window = new Window();
                window.setPosition(item.getMouseEventDetails().getClientX(), item.getMouseEventDetails().getClientY());
                window.setDraggable(true);
                UserFormView userFormView = new UserFormView();
                userFormView.setUser(item.getItem());
                FormLayout formLayout = userFormView.createFormLayout();
                formLayout.setMargin(true);
                window.setContent(formLayout);
                UI.getCurrent().addWindow(window);
                grid.setItems(userList);
            }
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome to the User List");
    }
}
