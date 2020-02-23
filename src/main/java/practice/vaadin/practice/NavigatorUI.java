package practice.vaadin.practice;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import lombok.Getter;
import practice.vaadin.practice.grid.GridView;

@SpringUI
public class NavigatorUI extends UI {

    @Getter
    private Navigator navigator;

    @Override
    protected void init(VaadinRequest request){
        navigator = new Navigator(this, this);
        setNavigator(navigator);
        navigator.addView("", new ExampleVaadinUI());
        navigator.addView("grid", new GridView());
    }
}
