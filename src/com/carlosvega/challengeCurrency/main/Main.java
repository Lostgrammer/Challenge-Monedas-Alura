package com.carlosvega.challengeCurrency.main;

import com.carlosvega.challengeCurrency.modules.Currency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca el codigo de la moneda que quiere encontrar");
        String currencyCode = input.nextLine();
        Currency currency = new Currency();
        String testLink = currency.test(currencyCode);
        System.out.println(testLink);
    }
}
