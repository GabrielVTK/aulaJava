package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {
    
    private Label screen;
    private String number1;
    private String number2;
    private char operator;
    private boolean pointFloating;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        this.screen = new Label();
        this.operator = ' ';
        this.number1 = "0";
        this.number2 = "0";
        this.pointFloating = false;
        
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        VBox numbers = new VBox();
        numbers.setSpacing(5);
        
        VBox auxKey = new VBox();
        auxKey.setSpacing(5);
        
        HBox div = new HBox();
        div.setSpacing(5);
        
        Scene scene = new Scene(vBox, 201, 180);
        
        screen.setMinSize(scene.getWidth(), 30);
        screen.setStyle("-fx-background-color: #FFF");
        
        vBox.getChildren().add(screen);
        
        AddOperators(vBox);
        AddNumbers(numbers);
        
        Button result = new Button("=");
        result.setMinSize(35.5, 55);
        result.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resolve();
                screen.setText(number1);
            }
        });
        
        Button clean = new Button("C");
        clean.setMinSize(35.5, 55);
        clean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                number1 = "0";
                number2 = "0";
                operator = ' ';
                pointFloating = false;
                screen.setText("");
            }
        });
        
        auxKey.getChildren().add(result);
        auxKey.getChildren().add(clean);
        
        div.getChildren().add(numbers);
        div.getChildren().add(auxKey);
        vBox.getChildren().add(div);
        
        stage.setScene(scene);
        stage.setTitle("Calculadora de Forças");
        stage.show();
    }
    
    public void resolve() {
        
        switch(operator) {
            case '+':
                number1 = String.valueOf(Float.parseFloat(number1) + Float.parseFloat(number2));
                break;
            case '-':
                number1 = String.valueOf(Float.parseFloat(number1) - Float.parseFloat(number2));
                break;
            case '*':
                number1 = String.valueOf(Float.parseFloat(number1) * Float.parseFloat(number2));
                break;
            case '/':
                number1 = String.valueOf(Float.parseFloat(number1) / Float.parseFloat(number2));
                break;
        }
        
        number2 = "0";
        operator = ' ';
        pointFloating = false;
    }
    
    private void AddOperators(VBox vBox) {
        
        double width = 46;
        double height = 20;
        
        EventHandler operatorAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                String operatorScreen = event.getSource().toString().split("button]'")[1].substring(0, 1);
                
                if(operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    resolve();
                    operator = operatorScreen.charAt(0);
                    screen.setText(number1 + " " + operatorScreen + " ");
                } else {
                    operator = operatorScreen.charAt(0);
                    screen.setText(screen.getText() + " " + operatorScreen + " ");
                }

            }
        };
        
        Button add = new Button("+");
        add.setMinSize(width, height);
        add.setOnAction(operatorAction);
        
        Button sub = new Button("-");
        sub.setMinSize(width, height);
        sub.setOnAction(operatorAction);
        
        Button mult = new Button("*");
        mult.setMinSize(width, height);
        mult.setOnAction(operatorAction);
        
        Button div = new Button("/");
        div.setMinSize(width, height);
        div.setOnAction(operatorAction);
        
        HBox line = new HBox();
        line.setSpacing(5);
        line.getChildren().add(add);
        line.getChildren().add(sub);
        line.getChildren().add(mult);
        line.getChildren().add(div);
        
        vBox.getChildren().add(line);
    }
    
    private void AddNumbers(VBox vBox) {
        
        HBox line = new HBox();
        line.setSpacing(5);
        int elements = 0;
        
        for(int i = 9; i >= 0; i--) {
            
            if(elements == 3) {
                vBox.getChildren().add(line);
                line = new HBox();
                line.setSpacing(5);
                elements = 0;
            }
            
            Button number = new Button(String.valueOf(i));
            number.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    if(operator == ' ') {
                        number1 += number.getText();
                    } else {
                        number2 += number.getText();
                    }
                    
                    screen.setText(screen.getText() + number.getText());
                }
            });
            
            if(i > 0) {
                number.setMinSize(50, 20);
                line.getChildren().add(number);
                elements++;
            } else {
                number.setMinSize(105, 20);
                
                Button point = new Button(".");
                point.setMinSize(50, 20);
                point.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        if(!pointFloating) {
                            if(operator == ' ') {
                                number1 += ".";
                            } else {
                                number2 += ".";
                            }

                            pointFloating = true;
                            screen.setText(screen.getText() + ".");
                        }
                        
                    }
                });
                
                line.getChildren().add(number);
                line.getChildren().add(point);
                vBox.getChildren().add(line);
                
                break;
            }
            
        }
        
    }
    
}
