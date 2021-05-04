package com.jackson.spring.files.csv.springbootuploadcsv.service;

import com.jackson.spring.files.csv.springbootuploadcsv.helper.CSVHelper;
import com.jackson.spring.files.csv.springbootuploadcsv.model.Tutorial;
import com.jackson.spring.files.csv.springbootuploadcsv.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}
