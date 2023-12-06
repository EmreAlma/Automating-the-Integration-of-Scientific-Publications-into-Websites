package com.example.pubsync.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name= "PUBLICATIONS")
public class Publication {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "publication_link")
    private String publishLink;
    @Column(name = "venue")
    private String venue;
    @Column(name = "pages")
    private String pages;
    @Column(name = "access")
    private String access;
    @Column(name = "publication_year")
    private String year;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "author_key")
    private String key;
    @Column(name = "pageURL")
    private String pageURL;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> publishAuthors;
    @Column(name = "doi")
    private String doiNumber;
    @Column(name = "pdf_link")
    private String pdfLink;
    @Column(name = "is_exportable" )
    private boolean isExportable;
    @Column(name = "add_date")
    private Instant addDate;

    @Column(name = "is_new")
    private boolean isNew;

    public Publication() {
    }

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

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
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

    public boolean isExportable() {
        return isExportable;
    }

    public void setExportable(boolean exportable) {
        isExportable = exportable;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public boolean isNew() { return isNew; }

    public void setIsNew(boolean isNew) { this.isNew = isNew; }

}