package com.example.pubsync.model;


import java.util.List;
import java.util.UUID;

public class PublicationView {

    private UUID id;
    private String publishLink;
    private String venue;
    private String year;
    private String title;
    private List<String> publishAuthors;
    private String doiNumber;
    private String pdfLink;
    private boolean isExportable;

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

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public boolean getIsExportable() {
        return isExportable;
    }

    public void setIsExportable(boolean isExportable) {
        this.isExportable = isExportable;
    }
}