package com.carlosvega.challengeCurrency.modules;

import java.util.Iterator;
import java.util.Map;

public class Currency {

    private int quantity;
    private Map <String, Double> conversion_rates;
    String secundaryCureencyChoice;
    double currencyRate;
    private String userCurrencyChoice;
    private double resultConvertion;

    //constructor
    public Currency(CurrencyApi currencyApi){
        this.conversion_rates = currencyApi.conversion_rates();
    }

    //getter and setter
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //methods
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


    //choose value similar secondchoice variable and get rate
    public void currencyRate(){
        Iterator it = conversion_rates.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            if (key.equalsIgnoreCase(secundaryCureencyChoice)){
                currencyRate = conversion_rates.get(key);
            }
        }
    }

    public void resultConvertion(){
        resultConvertion = quantity * currencyRate;
    }

    public void convertionResultMessage(){
        currencyRate();
        resultConvertion();
        System.out.println("El valor de " + quantity + " [" +
                userCurrencyChoice.toUpperCase() +
                "] corresponde al valor de final de =>>> " +
                 resultConvertion + "[" + secundaryCureencyChoice.toUpperCase() + "]");
    }

}
