package com.carlosvega.challengeCurrency.modules;

import java.util.Iterator;
import java.util.Map;

public class Currency {

    //variables
    private int quantity = 0;
    private Map <String, Double> conversion_rates;
    String secundaryCureencyChoice = "";
    double currencyRate = 0;
    private String userCurrencyChoice = "";
    private double resultConvertion = 0;

    //constructor
    public Currency(CurrencyApi currencyApi){
        this.conversion_rates = currencyApi.conversion_rates();
    }

    //setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //methods
    //set value of secundaryCureencyChoice
    public void secondCurrencyChoice(Address address){
        userCurrencyChoice = address.getUserCurrencyChoice();
        int userChoice = address.getUserChoice();
        if (userChoice == 2 || userChoice == 4 || userChoice == 6) secundaryCureencyChoice = address.getUsdCode();
        else if (userChoice == 1) {
            secundaryCureencyChoice = address.getPesoArgentinaCode();
        } else if (userChoice == 3) {
            secundaryCureencyChoice = address.getRealBrazilCode();
        }else if (userChoice == 5) {
            secundaryCureencyChoice = address.getPesoColombiaCode();
        }
    }
    //found currency rate according to choice
    public void currencyRate(){
        Iterator it = conversion_rates.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            if (key.equalsIgnoreCase(secundaryCureencyChoice)){
                currencyRate = conversion_rates.get(key);
            }
        }
    }
    //set value of the convertion result
    public void resultConvertion(){
        resultConvertion = quantity * currencyRate;
    }
    //print message
    public void convertionResultMessage(){
        currencyRate();
        resultConvertion();
        System.out.println("El valor de " + quantity + " [" +
                userCurrencyChoice.toUpperCase() +
                "] corresponde al valor de final de =>>> " +
                 resultConvertion + "[" + secundaryCureencyChoice.toUpperCase() + "]");
    }
}
