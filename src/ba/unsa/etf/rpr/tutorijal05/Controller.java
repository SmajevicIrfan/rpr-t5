package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    private SimpleStringProperty result;

    private String previousOperand = "";
    private String operator = "";
    
    private boolean clearResult = true;

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

        if (clearResult) {
            result.set(source.getText());
            clearResult = false;
        } else {
            result.set(result.getValue() + source.getText());
        }
    }

    public void dotBtn(ActionEvent actionEvent) {
        if (!result.getValue().contains(".")) {
            result.set(result.getValue() + ".");
        }
    }

    public void btnOperator(ActionEvent actionEvent) {
        if (!(actionEvent.getSource() instanceof Button)) {
            throw new IllegalArgumentException("Controller only for buttons (with numbers 1-9)");
        }

        Button source = (Button) actionEvent.getSource();

        setNewResult();
        operator = source.getText();
    }

    public void btnEquals(ActionEvent actionEvent) {
        setNewResult();
        operator = "";
        clearResult = true;
    }

    private void setNewResult() {
        if (operator.equals("") || previousOperand.equals("") || clearResult) {
            previousOperand = result.getValue();
            clearResult = true;
            return;
        }

        clearResult = true;
        if (operator.equals("+")) {
            result.set(
                    Double.toString(Double.parseDouble(previousOperand) + Double.parseDouble(result.getValue()))
            );
        } else if (operator.equals("-")) {
            result.set(
                    Double.toString(Double.parseDouble(previousOperand) + Double.parseDouble(result.getValue()))
            );
        } else if (operator.equals("x")) {
            result.set(
                    Double.toString(Double.parseDouble(previousOperand) * Double.parseDouble(result.getValue()))
            );
        } else if (operator.equals("/")) {
            result.set(
                    Double.toString(Double.parseDouble(previousOperand) / Double.parseDouble(result.getValue()))
            );
        } else if (operator.equals("%")) {
            result.set(
                    Double.toString(Double.parseDouble(previousOperand) % Double.parseDouble(result.getValue()))
            );
        }

        previousOperand = result.getValue();
    }
}
