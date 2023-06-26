package com.example.pubsync.service;

import com.example.pubsync.model.Response;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FirstService {

    public String getTestData(String param){
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://dblp.org/search/publ/api?q=test&format="+param))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            var testObject = gson.fromJson(response.body(), FirstService.class);
            return response.body();

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  "";
    }
    public String getAuthor(String param, String year){
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://dblp.org/search/publ/api?q="+param+"$+"+year+"&format=json"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Response responseBody = gson.fromJson(response.body(), Response.class);
            return response.body();

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  "";
    }
    public String getAuthorsPage(String param ){
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://dblp.org/search/publ/api?q=author%3A"+param+"%3A&format=json"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            var responseBody = gson.fromJson(response.body(), Response.class);
            return response.body();

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
