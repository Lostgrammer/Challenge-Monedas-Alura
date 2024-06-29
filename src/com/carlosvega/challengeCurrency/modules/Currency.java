package com.carlosvega.challengeCurrency.modules;

import java.util.Map;

public class Currency {

    private int quantity;
    private String usdCode = "usd";
    private String pesoArgentinaCode = "ars";
    private String realBrazilCode = "brl";
    private String pesoColombiaCode = "cop";
    private Map <String, Double> conversion_rates;
    private String base_code;

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
    public String secondCurrencyChoice(int userChoice){
        if (userChoice == 2 || userChoice == 4 || userChoice == 6) return usdCode;
        else if (userChoice == 1) {
            return pesoArgentinaCode;
        } else if (userChoice == 3) {
            return realBrazilCode;
        }else if (userChoice == 5) {
            return pesoColombiaCode;
        }
        return "";
    }

    public void currencyRate(){
        System.out.println(base_code);
        conversion_rates.forEach((currency, rate)->
                System.out.println(currency + " " +rate));
    }

}
