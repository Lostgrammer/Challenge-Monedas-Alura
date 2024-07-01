package com.carlosvega.challengeCurrency.modules;

public class Address{
    private String baseUrl = "https://v6.exchangerate-api.com/v6/e3faad7790933299afb32ed2/latest/";
    private int userChoice = 0;
    private String usdCode = "usd";
    private String pesoArgentinaCode = "ars";
    private String realBrazilCode = "brl";
    private String pesoColombiaCode = "cop";
    private String comparedCurrencyCode;
    private String userCurrencyChoice;

    //getters setters
    public int getUserChoice() {
        return userChoice;
    }
    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

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

    public String getUrl(){
        this.comparedCurrencyCode = setCurrencyCode();
        return baseUrl + comparedCurrencyCode;
    }

    //methods
    public String setCurrencyCode(){
        int userChoice = getUserChoice();
        if (userChoice == 1 || userChoice == 3 || userChoice == 5) userCurrencyChoice = usdCode;
        else if (userChoice == 2) {
            userCurrencyChoice = pesoArgentinaCode;
        } else if (userChoice == 4) {
            userCurrencyChoice = realBrazilCode;
        }else if (userChoice == 6) {
            userCurrencyChoice = pesoColombiaCode;
        }else if (userChoice == 7) {
            finishProgram();
        }else {
            System.out.println("Error intentelo nuevamente");
        }
        return userCurrencyChoice;
    }
    public void finishProgram(){
        System.out.println("Finalizado el programa, gracias por su visita :)");
    }

}
