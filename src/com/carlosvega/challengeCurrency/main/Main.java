package com.carlosvega.challengeCurrency.main;

import com.carlosvega.challengeCurrency.modules.Address;
import com.carlosvega.challengeCurrency.modules.Currency;
import com.carlosvega.challengeCurrency.modules.CurrencyApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int valueExitProgram = 7;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()//para ordenar el json
                .create();
        Scanner input = new Scanner(System.in);
        String json;
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


        //http request and response
        Address address = new Address();

        do{
            //init program
            System.out.print(initialMessage);
            address.setUserChoice(input.nextInt());
            input.nextLine();
            if (address.getUserChoice() > valueExitProgram || address.getUserChoice() <= 0 ){
                continue;
            } else if (address.getUserChoice() != valueExitProgram) {
                URI addressURI = URI.create(address.getUrl());
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(addressURI)
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                json = response.body();
                //deserialization
                CurrencyApi currencyApi = gson.fromJson(json,CurrencyApi.class);

                Currency newCurrency = new Currency(currencyApi);
                System.out.println(valueMessage);
                newCurrency.setQuantity(input.nextInt());
                input.nextLine();

                newCurrency.secondCurrencyChoice(address);
                newCurrency.convertionResultMessage();
            }
//            else {
//                break;
//            }


        }while(address.getUserChoice() != valueExitProgram);
    }
}


