package com.example.pubsync.service;

import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationsRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FirstService {

    private final ConverterService converterService;

    private final PublicationsRepository publicationsRepository;

    public FirstService(ConverterService converterService, PublicationsRepository publicationsRepository) {
        this.converterService = converterService;
        this.publicationsRepository = publicationsRepository;
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
            var convertedModel = converterService.publicationsList(responseBody);
            publicationsRepository.saveAll(convertedModel);

            return response.body();

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
