package practice.vaadin.practice;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;


public class VaadinUI extends VerticalLayout implements View {

    public VaadinUI() {

        Button gridButton = new Button("Show Grid List", event -> {
            getUI().getNavigator().navigateTo("grid");
        });
        Button addUserButton = new Button("Add User", event -> {
            getUI().getNavigator().navigateTo("user-form");
        });

        addComponents(gridButton, addUserButton);

    }

}
