package com.carlosvega.challengeCurrency.main;

import com.carlosvega.challengeCurrency.modules.Currency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String testLink;
        int userChoice;
        String secondValue;
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
        secondValue = input.nextLine();
        //metodo que reciba ambos valores para hacer operaciones
        //obj1.convertidor(userChoice, secondValue)

//        String currencyCode = input.nextLine();
//        Currency currency = new Currency();
//        testLink = currency.test(currencyCode);
//        System.out.println(testLink);
    }
}
