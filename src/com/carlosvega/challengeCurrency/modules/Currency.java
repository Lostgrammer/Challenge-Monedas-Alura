package com.carlosvega.challengeCurrency.modules;

import java.util.Iterator;
import java.util.Map;

public class Currency {

    private int quantity;
    private Map <String, Double> conversion_rates;
    private String base_code;
    String secundaryCureencyChoice;
    double currencyRate;

    //constructor
    public Currency(CurrencyApi currencyApi){
        this.base_code = currencyApi.base_code();
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

    public void currencyRate(){
        System.out.println(base_code);
        conversion_rates.forEach((currency, rate)->
                System.out.println(currency + " " +rate));
    }
    //choose value similar secondchoice variable and get rate
    public void currencyRate1(){
        Iterator it = conversion_rates.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            if (key.equalsIgnoreCase(secundaryCureencyChoice)){
                System.out.println(key + " +  " + conversion_rates.get(key));
            }
        }
    }

}
