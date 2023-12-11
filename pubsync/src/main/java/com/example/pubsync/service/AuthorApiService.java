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

            if (response.statusCode() != 200) {
                throw new AuthorNotFoundException("Author not found or error in API response for: " + param);
            }

            Response parsedResponse = gson.fromJson(response.body(), Response.class);
            if (parsedResponse == null || parsedResponse.getResult() == null || parsedResponse.getResult().getHits().getHit() == null) {
                throw new AuthorNotFoundException("No valid data found for author: " + param);
            }

            return parsedResponse;

        } catch (IOException | InterruptedException e) {
            throw new DatabaseUnavailableException("Database server is temporarily unavailable: " + e.getMessage());
        }
    }

}