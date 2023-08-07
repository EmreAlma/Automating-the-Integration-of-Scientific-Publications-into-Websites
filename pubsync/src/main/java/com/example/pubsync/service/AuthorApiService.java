package com.example.pubsync.service;

import com.example.pubsync.model.Response;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This class provides a service for interacting with the DBLP API (https://dblp.org),
 * facilitating the retrieval of author information from a data source and parsing the response using Gson.
 */
@Service
public class AuthorApiService {
    /**
     * Gson object for JSON parsing.
     */
    private final Gson gson;
    /**
     * Constructs an AuthorApiService with the provided Gson object.
     * @param gson Gson object for JSON parsing.
     */
    public AuthorApiService(Gson gson) {
        this.gson = gson;
    }

    /**
     * Retrieves author information from the external API based on the parameter.
     * @param param Search parameter for author page.
     * @return Parsed Response object from the API.
     */
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