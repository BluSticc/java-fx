package com.katamari.javafxcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    private Label lblResult;
    private double number1 = 0;
    private String operator = "+";

    @FXML
    void numberButton(MouseEvent event) {
        int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("btn", ""));
        lblResult.setText(Double.parseDouble(lblResult.getText()) == 0 ? String.valueOf((double) value) : String.valueOf(Double.parseDouble(lblResult.getText()) * 10 + value));
    }

    @FXML
    void operationButton(MouseEvent event) {
        String operation = ((Pane) event.getSource()).getId().replace("btn", "");
        if (operation.equals("Equals")) {
            double number2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+":
                    lblResult.setText((number1 + number2) + "");
                    break;
                case "-":
                    lblResult.setText((number1 - number2) + "");
                    break;
                case "*":
                    lblResult.setText((number1 * number2) + "");
                    break;
                case "/":
                    lblResult.setText((number1 / number2) + "");
                    break;
            }
            operator = ".";
        } else if (operation.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
        } else {
            switch (operation) {
                case "Plus":
                    operator = "+";
                    break;
                case "Minus":
                    operator = "-";
                    break;

                case "Multiply":
                    operator = "*";
                    break;
                case "Divide":
                    operator = "/";
                    break;
            }
            number1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }
}