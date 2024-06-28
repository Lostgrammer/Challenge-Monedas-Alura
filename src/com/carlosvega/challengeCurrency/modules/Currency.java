package com.carlosvega.challengeCurrency.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;

public class Currency {

    private String baseUrl = "https://v6.exchangerate-api.com/v6/e3faad7790933299afb32ed2/latest/";
    private String usdCode = "usd";
    private String pesoArgentinaCode = "ars";
    private String realBrazilCode = "brl";
    private String pespColombiaCode = "cop";
    private String comparedCurrencyCode;

    public CurrencyApi searchConvertionRate(int userChoice){
        this.comparedCurrencyCode = setCurrencyCode(userChoice);
        URI address = URI.create(this.baseUrl + comparedCurrencyCode);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyApi.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //methods
    public String setCurrencyCode(int userChoice){
        if (userChoice == 1 || userChoice == 3 || userChoice == 5) return usdCode;
        else if (userChoice == 2) {
            return pesoArgentinaCode;
        } else if (userChoice == 4) {
            return realBrazilCode;
        }else if (userChoice == 6) {
            return pespColombiaCode;
        }
        return "";
    }

}
