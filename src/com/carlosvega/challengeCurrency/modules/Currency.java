package com.carlosvega.challengeCurrency.modules;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Currency {
    private String baseUrl = "https://v6.exchangerate-api.com/v6/e3faad7790933299afb32ed2/latest/";

    public String test (String currencyuCode){
        URI address = URI.create(this.baseUrl += currencyuCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
    }


}
