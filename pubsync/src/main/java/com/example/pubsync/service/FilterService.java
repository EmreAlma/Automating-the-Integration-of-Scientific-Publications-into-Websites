package com.example.pubsync.service;

import com.example.pubsync.entity.Publications;
import com.example.pubsync.repository.PublicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {

    @Autowired
    private PublicationsRepository publicationsRepository;

    public List<Publications> fetchAndSaveNewPublications(List<Publications> databankPublications){
        List<Publications> databasePublications = publicationsRepository.findAll();
        List<Publications> filteredList = new ArrayList<>();

        for(Publications databankPublication : databankPublications) {
            boolean isExist = false;
            for (Publications databasePublication : databasePublications){
                if (databankPublication.getPublishLink().equals(databasePublication.getPublishLink())){
                    isExist = true;
                    break;
                }

            }
                if(isExist){
                    continue;
            }
            filteredList.add(databankPublication);
        }
        return filteredList;
    }


}
