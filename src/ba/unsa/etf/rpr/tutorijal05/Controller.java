package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    private SimpleStringProperty result;

    private String previousOperand = "";
    private String operator = "";

    public Controller() {
        result = new SimpleStringProperty("0");
    }

    public String getResult() {
        return result.get();
    }

    public SimpleStringProperty resultProperty() {
        return result;
    }

    public void btn0(ActionEvent actionEvent) {
        if (!result.getValue().equals("0")) {
            result.set(result.getValue() + "0");
        }
    }


    public void btnNumber(ActionEvent actionEvent) {
        if (!(actionEvent.getSource() instanceof Button)) {
            throw new IllegalArgumentException("Controller only for buttons (with numbers 1-9)");
        }
        Button source = (Button) actionEvent.getSource();

        if (result.getValue().equals("0")) {
            result.set(source.getText());
        } else {
            result.set(result.getValue() + source.getText());
        }
    }
}
