package com.example.pubsync.service;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterService {
    private final Gson gson;

    public ConverterService(Gson gson) {
        this.gson = gson;
    }

    public List<Publication> convertResponsePublicationsList(Response response) {
        List<Publication> publicationList = new ArrayList<>();
        if (response.getResult() != null && response.getResult().getHits() != null) {
            List<HitItem> hits = response.getResult().getHits().getHit();
            for (var hit : hits) {
                var info = hit.getInfo();
                Publication publication = new Publication();
                publication.setPublishLink(info.getEe());
                publication.setDoiNumber(info.getDoi());
                publication.setAccess(info.getAccess());
                publication.setPageURL(info.getUrl());
                if (info.getVenue() != null) publication.setVenue(info.getVenue().toString());
                publication.setYear(info.getYear());
                publication.setType(info.getType());
                publication.setTitle(info.getTitle());
                publication.setPages(info.getPages());
                publication.setKey(info.getKey());
                publication.setPublishAuthors(parsePublishAuthors(info));
                publication.setExportable(true);
                publication.setAddDate(Instant.now());
                publication.setIsNew(publication.getAddDate().compareTo(ZonedDateTime.now().minusMinutes(3).toInstant())>=0);


                publicationList.add(publication);
            }
        }
        return publicationList;
    }

    public List<String> parsePublishAuthors(Info info) {
        List<String> authors = new ArrayList<>();
        Object authorObject = info.getAuthors().getAuthor();

        if (authorObject instanceof List<?>) {
            Type authorListType = new TypeToken<List<AuthorItem>>(){}.getType();
            String jsonStr = gson.toJson(authorObject);
            List<AuthorItem> authorItemList = gson.fromJson(jsonStr, authorListType);
            authors = authorItemList.stream().map(AuthorItem::getText).map(this::removeNumbersFromAuthor).collect(Collectors.toList());
        }
        return authors;
    }

    private String removeNumbersFromAuthor(String author) {
        return author.replaceAll("\\d", "").trim();
    }
}