package practice.vaadin.practice.grid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

import java.util.List;


public class GridView extends GridLayout implements View {
    private List<User> userList;

    private boolean getUserList(){
        UserData userData = new UserData();
        userList = userData.getUserList();
        return userList != null;
    }
    public GridView() {
        if (!getUserList()){
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

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        Notification.show("Welcome to the User List");
    }
}
