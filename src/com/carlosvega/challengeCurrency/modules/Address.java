package com.carlosvega.challengeCurrency.modules;

public class Address{
    //variables
    private String baseUrl = "https://v6.exchangerate-api.com/v6/e3faad7790933299afb32ed2/latest/";
    private int userChoice = 0;
    private String usdCode = "usd";
    private String pesoArgentinaCode = "ars";
    private String realBrazilCode = "brl";
    private String pesoColombiaCode = "cop";
    private String comparedCurrencyCode = "";
    private String userCurrencyChoice = "";

    //getters setters
    public String getUsdCode() {
        return usdCode;
    }
    public String getPesoArgentinaCode() {
        return pesoArgentinaCode;
    }
    public String getRealBrazilCode() {
        return realBrazilCode;
    }
    public String getPesoColombiaCode() {
        return pesoColombiaCode;
    }
    public String getUserCurrencyChoice() {
        return userCurrencyChoice;
    }
    public int getUserChoice() {
        return userChoice;
    }
    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    //methods
    //get url
    public String getUrl(){
        this.comparedCurrencyCode = setCurrencyCode();
        return baseUrl + comparedCurrencyCode;
    }

    //set currency code string for url
    public String setCurrencyCode(){
        int userChoice = getUserChoice();
        if (userChoice == 1 || userChoice == 3 || userChoice == 5) userCurrencyChoice = usdCode;
        else if (userChoice == 2) {
            userCurrencyChoice = pesoArgentinaCode;
        } else if (userChoice == 4) {
            userCurrencyChoice = realBrazilCode;
        }else if (userChoice == 6) {
            userCurrencyChoice = pesoColombiaCode;
        }
        return userCurrencyChoice;
    }
    //finish program message
    public void finishProgram(){
        System.out.println("Finalizado el programa, gracias por su visita :)");
    }
    //try again message
    public void tryAgain(){
        System.out.println("Opcion invalida, intentelo nuevamente");
    }
}
