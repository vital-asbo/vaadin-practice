package practice.vaadin.practice;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.web.client.RestTemplate;


public class ExampleVaadinUI extends VerticalLayout implements View {
//
//    public VerticalLayout rootLayout;
//
//    public ExampleVaadinUI() {
//        rootLayout = new VerticalLayout();
//        setContent(rootLayout);
//    }

//    @Override
//    protected void init(VaadinRequest vaadinRequest) {

////        VerticalLayout verticalLayout = new VerticalLayout();
////        TextField tf = new TextField("Your Name");
////        Button button = new Button("Action");
////        button.addClickListener(x -> Notification.show(tf.getValue()));
////        verticalLayout.addComponents(tf, button);
////        setContent(verticalLayout);
//        TextField tf = new TextField("Enter Your Name");
//        Button button = new Button("Action");
//        button.addClickListener(x -> Notification.show(tf.getValue()));
//        rootLayout.addComponents(tf, button);
//        Button button2 = new Button("Call rest service", event -> callRestService());
//        rootLayout.addComponents(button2);

//    }

    private void callRestService(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9090/rest", String.class);
        Notification.show(result);
    }

    public ExampleVaadinUI(){
        TextField tf = new TextField("Enter Your Name");
        Button button = new Button("Action");
        button.addClickListener(x -> Notification.show(tf.getValue()));
        addComponents(tf, button);
        Button button2 = new Button("Call rest service", event -> callRestService());

        Button button3 = new Button("Show grid list", event ->{
            getUI().getNavigator().navigateTo("grid");
        });

        addComponents(button2, button3);

    }

}
