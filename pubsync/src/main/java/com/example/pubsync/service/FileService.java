package com.example.pubsync.service;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FileService {

    private final PublicationRepository publicationRepository;

    public FileService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    public void createMarkdownFile(String filePath) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            List<Integer> publicationYears = publicationRepository.findDistinctPublicationYears();
            writer.println("---");
            writer.println("title: \"Publications\"");
            writer.println("bg_image: \"images/2020-landscape-2.png\"");
            writer.println("description: \"This is meta description\"");
            writer.println("draft: false");
            writer.println("weight: 2");
            writer.println("---");
            writer.println();
            writer.println("{{< rawhtml >}}");
            writer.println("  <p class=\"speshal-fancy-custom\">");
            writer.println("  </p>");
            writer.println("{{< /rawhtml >}}");
            writer.println();

            for (Integer year : publicationYears) {
                writer.println("## " + year);
                List<Publication> publicationsOfYear = publicationRepository.findAllByYear(year.toString());

                for (Publication publication : publicationsOfYear) {
                    if (!publication.isExportable()) continue;

                    writer.println();
                    writer.println("- " + String.join(", ", publication.getPublishAuthors()) + ". ");
                    writer.println(publication.getTitle() + ". _" + publication.getVenue() + ", " + publication.getYear() + "_.  ");
                    writer.println("[[Link]](" + publication.getPublishLink() + ") ");
                    if (publication.getPdfLink() != null) {
                        writer.println("[[Paper]](" + publication.getPdfLink() + ") ");
                    }
                    writer.println();
                }
            }
        }
    }
}
