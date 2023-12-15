package com.example.pubsync.service;

import com.example.pubsync.exception.AuthorNotFoundException;
import com.example.pubsync.exception.DatabaseUnavailableException;
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

    public Response getAuthorsPage(String param) throws AuthorNotFoundException, DatabaseUnavailableException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://dblp.org/search/publ/api?q=author%3A" + param + "%3A&format=json&h=1000"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            switch (response.statusCode()) {
                case 200 -> {
                    Response parsedResponse = gson.fromJson(response.body(), Response.class);
                    if (parsedResponse == null || parsedResponse.getResult() == null ||
                            parsedResponse.getResult().getHits() == null || parsedResponse.getResult().getHits().getHit() == null) {
                        throw new AuthorNotFoundException("No valid data found for author: " + param +
                                "\r\nPlease make sure the author's name is spelled correctly.");
                    }
                    return parsedResponse;
                }
                case 400 -> throw new AuthorNotFoundException("Request contains incorrect syntax for: " + param);
                case 404 -> throw new AuthorNotFoundException("Author not found: " + param);
                case 500 ->
                        throw new DatabaseUnavailableException("Database server is temporarily unavailable: " + response.body());
                default -> throw new AuthorNotFoundException("Error in API response for: " + param);
            }

        } catch (IOException | InterruptedException e) {
            throw new DatabaseUnavailableException("Database server is temporarily unavailable: " + e.getMessage());
        }
    }
}