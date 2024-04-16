package service;

import com.google.gson.Gson;
import models.Rate;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {

    //GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD

    //GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT

     //dee9848bc3b803cdedf725b5

    public Rate search(String baseCode, String targetCode, Double quantity){

        URI address = URI.create("https://v6.exchangerate-api.com/v6/dee9848bc3b803cdedf725b5/pair/"+ baseCode + "/" + targetCode + "/" + quantity);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(" Erro ao converter!");
        }
        return new Gson().fromJson(response.body(), Rate.class);
    }
}
