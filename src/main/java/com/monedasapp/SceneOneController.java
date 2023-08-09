package com.monedasapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SceneOneController implements Initializable {

    @FXML
    private ChoiceBox<String> mainCountryBox, countryBox;
    @FXML
    private Label titleLabel;
    @FXML
    private Label finalValueLabel;
    @FXML
    private TextField amountField;

    private ArrayList<String> countries = new ArrayList<>(Arrays.asList("USD", "MX", "CO", "ARG", "EUR"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainCountryBox.getItems().addAll(countries);
        countryBox.getItems().addAll(countries);
        // mainCountryBox.setOnAction(this::updateTitleLabel);
        mainCountryBox.setValue(countries.get(0));
        countryBox.setOnAction(this::updateTitleLabel);
    }

    public void updateTitleLabel(ActionEvent event) {
        String countryCoinOne = mainCountryBox.getValue();
        String countryCoinTwo = countryBox.getValue();

        countryCoinOne = (countryCoinOne != null) ? countryCoinOne : "USD";

        try {
            Double value = Double.parseDouble(amountField.getText());
            currencyConversion(countryCoinOne, countryCoinTwo, value);
        } catch (NumberFormatException e) {
            System.out.println(e);
            titleLabel.setText("Enter a Number");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void currencyConversion(String coin, String coin1, Double value) {
//        coin1 = (coin1 != null) ? coin1 : "USD";
        titleLabel.setText("Convert " + coin + " to " + coin1 + " at the real exchange rate");

        int positionFistCountry = countries.indexOf(coin);
        int positionSecondCountry = countries.indexOf(coin1);
        // System.out.println("position: " + positionFistCountry);
        // System.out.println("position2: " + positionSecondCountry);
        // System.out.println("Value: " + value);

        Coin exchange = new Coin(positionSecondCountry, value);
        Double valueExchange = exchange.conversion();

        String numberRounded = String.format("%.2f", valueExchange);


        // System.out.println("Valor: " + valueExchange);
        finalValueLabel.setText(String.valueOf(numberRounded));
    }
}
