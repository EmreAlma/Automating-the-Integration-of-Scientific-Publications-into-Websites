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
public class AuthorApiService {

    private final Gson gson;

    public AuthorApiService(Gson gson) {
        this.gson = gson;
    }

    public Response getAuthorsPage(String param) {
        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://dblp.org/search/publ/api?q=author%3A" + param + "%3A&format=json&h=200"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Response.class);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}