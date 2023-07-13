package com.example.pubsync.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name= "publications")
public class Publications {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Authors authors;
    @Column(name = "publicationLink")
    private String publishLink;
    @Column(name = "venue")
    private String venue;
    @Column(name = "pages")
    private String pages;
    @Column(name = "access")
    private String access;
    @Column(name = "year")
    private String year;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "key")
    private String key;
    @Column(name = "authorPageURL")
    private String authorPageURL;
    @ElementCollection
    private List<String> publishAuthors;
    @Column(name = "name")
    private String doiNumber;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPublishLink() {
        return publishLink;
    }

    public void setPublishLink(String publishLink) {
        this.publishLink = publishLink;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthorPageURL() {
        return authorPageURL;
    }

    public void setAuthorPageURL(String authorPageURL) {
        this.authorPageURL = authorPageURL;
    }

    public List<String> getPublishAuthors() {
        return publishAuthors;
    }

    public void setPublishAuthors(List<String> publishAuthors) {
        this.publishAuthors = publishAuthors;
    }

    public String getDoiNumber() {
        return doiNumber;
    }

    public void setDoiNumber(String doiNumber) {
        this.doiNumber = doiNumber;
    }
}

