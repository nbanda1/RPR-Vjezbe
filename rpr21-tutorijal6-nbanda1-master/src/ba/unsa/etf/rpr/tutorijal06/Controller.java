package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label display;
    private String number;
    private char operator;
    private Double result;
    private Boolean equalUsed;

    public Controller(){
        number="";
        operator=' ';
        display=new Label();
        display.setText("0");
        result=Double.valueOf(0);
        equalUsed=true;
    }



    public void number0(MouseEvent mouseEvent) {
        if(number!=""){
            number += "0";
            display.setText(number);}
    }
    public void number1(MouseEvent mouseEvent) {
        number += "1";
        display.setText(number);
    }
    public void number2(MouseEvent mouseEvent) {
        number += "2";
        display.setText(number);
    }
    public void number3(MouseEvent mouseEvent) {
        number += "3";
        display.setText(number);
    }
    public void number4(MouseEvent mouseEvent) {
        number += "4";
        display.setText(number);
    }
    public void number5(MouseEvent mouseEvent) {
        number += "5";
        display.setText(number);
    }
    public void number6(MouseEvent mouseEvent) {
        number += "6";
        display.setText(number);
    }
    public void number7(MouseEvent mouseEvent) {
        number += "7";
        display.setText(number);
    }
    public void number8(MouseEvent mouseEvent) {
        number += "8";
        display.setText(number);
    }
    public void number9(MouseEvent mouseEvent) {
        number += "9";
        display.setText(number);
    }

    public void decimal(MouseEvent mouseEvent) {
        if(number==""){
            number="0.";
        }
        else number+=".";
        display.setText(number);
    }

    public void percentage(MouseEvent mouseEvent) {
        if(operator!=' ') {
            double x;
            if(number==""){
                x=result*(result/100);
            }
            else{
                x=result*(Double.parseDouble(number)/100);
            }
            number= String.valueOf(x);
            equalUsed=false;
            equals(mouseEvent);

        }
        else{
            number="";
            operator=' ';
            display.setText("0");
            result=Double.valueOf(0);
        }
    }

    public void div(MouseEvent mouseEvent) {
        if(operator==' ') {
            result= Double.parseDouble(number);
            number="";
            operator='/';
        }
        else{
            equalUsed=false;
            equals(mouseEvent);
        }
    }
    public void mult(MouseEvent mouseEvent) {
        if(operator==' ') {
            result= Double.parseDouble(number);
            number="";
            operator='*';
        }
        else {
            equalUsed=false;
            equals(mouseEvent);

        }
    }
    public void minus(MouseEvent mouseEvent) {
        if(operator==' ') {
            result= Double.parseDouble(number);
            number="";
            operator='-';
        }
        else {
            equalUsed=false;
            equals(mouseEvent);

        }
    }public void plus(MouseEvent mouseEvent) {
        if(operator==' ') {
            result= Double.parseDouble(number);
            number="";
            operator='+';
        }
        else {
            equalUsed=false;
            equals(mouseEvent);

        }
    }public void equals(MouseEvent mouseEvent) {
        if(operator!=' ') {
            Double x = Double.parseDouble(number);
            if (operator == '+') result = result + x;
            if (operator == '-') result = result - x;
            if (operator == '*') result = result * x;
            if (operator == '/') result = result / x;
            display.setText(Double.toString(result));
            number = "";
            if (equalUsed) {
                operator = ' ';
                result = Double.valueOf(0);
            }
            equalUsed = true;
        }
    }
}
