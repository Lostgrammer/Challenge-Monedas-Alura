package com.carlosvega.challengeCurrency.modules;

public class Address{
    private String baseUrl = "https://v6.exchangerate-api.com/v6/e3faad7790933299afb32ed2/latest/";
    private int userChoice;
    private String usdCode = "usd";
    private String pesoArgentinaCode = "ars";
    private String realBrazilCode = "brl";
    private String pesoColombiaCode = "cop";
    private String comparedCurrencyCode;

    //getters setters
    public int getUserChoice() {
        return userChoice;
    }
    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public String getUrl(){
        this.comparedCurrencyCode = setCurrencyCode();
        return baseUrl + comparedCurrencyCode;
    }

    //methods
    public String setCurrencyCode(){
        int userChoice = getUserChoice();
        if (userChoice == 1 || userChoice == 3 || userChoice == 5) return usdCode;
        else if (userChoice == 2) {
            return pesoArgentinaCode;
        } else if (userChoice == 4) {
            return realBrazilCode;
        }else if (userChoice == 6) {
            return pesoColombiaCode;
        }
        return "";
    }

}
