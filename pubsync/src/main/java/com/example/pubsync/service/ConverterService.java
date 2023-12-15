package com.example.pubsync.service;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for converting API response data into application-specific models.
 * Utilizes Gson for JSON parsing.
 */
@Service
public class ConverterService {
    private final Gson gson;

    /**
     * Constructs a ConverterService with a Gson object for JSON parsing.
     * @param gson Gson object used for parsing JSON.
     */
    public ConverterService(Gson gson) {
        this.gson = gson;
    }

    /**
     * Converts the API response into a list of Publication entities.
     * @param response The Response object containing the data to be converted.
     * @return A list of Publication entities.
     */
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
                publication.setIsNew(true);

                publicationList.add(publication);
            }
        }
        return publicationList;
    }

    /**
     * Parses the list of authors from a publication's information.
     * Extracts author names from the Info object and processes them to a standard format.
     *
     * @param info The Info object containing publication details, including author information.
     * @return A list of author names extracted and processed from the Info object.
     */
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

    /**
     * Removes numeric characters from an author's name.
     * This is used to clean up author names that may contain extraneous numeric data.
     *
     * @param author The author's name to be cleaned.
     * @return The author's name with numeric characters removed.
     */
    private String removeNumbersFromAuthor(String author) {
        return author.replaceAll("\\d", "").trim();
    }
}