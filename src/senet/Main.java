package senet;


public class Main {

    public static void main(String[] args) {
        Controller c = new Controller();
        UI ui = new UI();
        c.setUI(ui);
        ui.setController(c);
        ui.display();
    }

}