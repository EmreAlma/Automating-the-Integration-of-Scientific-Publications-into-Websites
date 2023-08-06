package com.example.pubsync.service;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.model.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterService {
    private final Gson gson;

    public ConverterService(Gson gson) {
        this.gson = gson;
    }

    public List<Publication> publicationsList(Response response) {
        List<Publication> publicationList = new ArrayList<>();
        List<HitItem> hits = response.getResult().getHits().getHit();
        for (var hit : hits) {
            var info = hit.getInfo();
            Publication publication = new Publication();
            publication.setPublishLink(info.getEe());
            publication.setDoiNumber(info.getDoi());
            publication.setAccess(info.getAccess());
            publication.setAuthorPageURL(info.getUrl());
            if (info.getVenue() != null) publication.setVenue(info.getVenue().toString());
            publication.setYear(info.getYear());
            publication.setType(info.getType());
            publication.setTitle(info.getTitle());
            publication.setPages(info.getPages());
            publication.setKey(info.getKey());
            publication.setPublishAuthors(parsePublishAuthors(info));

            publicationList.add(publication);

        }
        return publicationList;
    }


    public List<String> parsePublishAuthors(Info info) {
        List<String> authors = new ArrayList<>();
        if (info.getAuthors().getAuthor() instanceof List<?>) {
            List<AuthorItem> objects2 = (List<AuthorItem>) info.getAuthors().getAuthor();

            String jsonStr = gson.toJson(objects2);
            AuthorItem[] authorItem = gson.fromJson(jsonStr, AuthorItem[].class);
            authors = Arrays.stream(authorItem).map(x -> x.getText()).collect(Collectors.toList());
        }
        return authors;
    }
    public List<PublicationView> convertPublicationViewList(List<Publication> publicationList) {
        List<PublicationView> publicationViewList = new ArrayList<>();
        for (var publication : publicationList) {
            var publicationView = new PublicationView();
            publicationView.setPublishLink(publication.getPublishLink());
            publicationView.setVenue(publication.getVenue());
            publicationView.setYear(publication.getYear());
            publicationView.setTitle(publication.getTitle());
            List<String> authorsWithoutNumbers = removeNumbersFromAuthors(publication.getPublishAuthors());
            publicationView.setPublishAuthors(authorsWithoutNumbers);
            publicationView.setDoiNumber(publication.getDoiNumber());

            publicationViewList.add(publicationView);
        }

        return publicationViewList;
    }
    private List<String> removeNumbersFromAuthors(List<String> authors) {
        List<String> authorsWithoutNumbers = new ArrayList<>();
        for (String author : authors) {
            String authorWithoutNumbers = author.replaceAll("\\d", "").trim();
            authorsWithoutNumbers.add(authorWithoutNumbers);
        }
        return authorsWithoutNumbers;
    }
}
