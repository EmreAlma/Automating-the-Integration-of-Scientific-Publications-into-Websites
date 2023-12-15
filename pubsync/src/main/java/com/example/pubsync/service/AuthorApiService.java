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
 * Service class for interacting with the DBLP API.
 * Provides functionality to retrieve author information based on a search parameter and parse the response.
 */
@Service
public class AuthorApiService {
    private final Gson gson;

    /**
     * Constructs an AuthorApiService with a Gson object for JSON parsing.
     * @param gson Gson object used for parsing JSON responses from the API.
     */
    public AuthorApiService(Gson gson) {

        this.gson = gson;
    }
    /**
     * Retrieves author information from the DBLP API based on the provided search parameter.
     * @param param The search parameter used to query the DBLP API for author page.
     * @return A Response object containing the parsed data from the API response.
     * @throws AuthorNotFoundException If the author is not found or if the response is incorrect.
     * @throws DatabaseUnavailableException If there is an issue with the database connection.
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