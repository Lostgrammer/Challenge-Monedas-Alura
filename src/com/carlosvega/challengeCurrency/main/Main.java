package com.carlosvega.challengeCurrency.main;

import com.carlosvega.challengeCurrency.modules.Currency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String testLink;
        int userChoice;
        String comparedValue;
        String appAnswer;
        String initialMessage = "***************************************************\n" +
                "Sea bienvenido al conversor de moneda\n" +
                "Elija el tipo de cambio que desea realizar: \n" +
                "1) Dólar ==> Peso argentino \n" +
                "2) Peso argentino ==> Dólar \n" +
                "3) Dólar ==> Real brasileño \n" +
                "4) Real brasileño ==> Dólar \n" +
                "5) Dólar ==> Peso colombiano \n" +
                "6) Peso colombiano ==> Dólar \n" +
                "7) Salir \n" +
                "***************************************************\n" +
                "Su opcion es: ";
        String valueMessage = "Escriba la cantidad que desea convertir";

        //init app
        System.out.print(initialMessage);
        userChoice = input.nextInt();
        input.nextLine();
        System.out.println(valueMessage);
        comparedValue = input.nextLine();

        //metodo que reciba ambos valores para hacer operaciones
        Currency newCurrency = new Currency();
        System.out.println(newCurrency.searchConvertionRate("mxn"));
    }
}
