package com.example.pubsync.service;

import com.example.pubsync.entity.Publications;
import com.example.pubsync.model.HitItem;
import com.example.pubsync.model.Info;
import com.example.pubsync.model.Response;
import com.example.pubsync.model.AuthorItem;
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

    public List<Publications> publicationsList(Response response) {
        List<Publications> publicationsList = new ArrayList<>();
        List<HitItem> hits = response.getResult().getHits().getHit();
        for (var hit : hits) {
            var info = hit.getInfo();
            Publications publications = new Publications();
            publications.setPublishLink(info.getEe());
            publications.setDoiNumber(info.getDoi());
            publications.setAccess(info.getAccess());
            publications.setAuthorPageURL(info.getUrl());
            if (info.getVenue() != null) publications.setVenue(info.getVenue().toString());
            publications.setYear(info.getYear());
            publications.setType(info.getType());
            publications.setTitle(info.getTitle());
            publications.setPages(info.getPages());
            publications.setKey(info.getKey());
            publications.setPublishAuthors(parsePublishAuthors(info));

            publicationsList.add(publications);

        }
        return publicationsList;
    }


    public List<String> parsePublishAuthors(Info info) {
        List<String> authors = new ArrayList<>();
        if (info.getAuthors().getAuthor() instanceof List<?>) {
            List<AuthorItem> objects = (List<AuthorItem>) info.getAuthors().getAuthor();

            String jsonStr = gson.toJson(objects);
            AuthorItem[] authorItem = gson.fromJson(jsonStr, AuthorItem[].class);
            authors = Arrays.stream(authorItem).map(x -> x.getText()).collect(Collectors.toList());

        }
        return authors;
    }
}
