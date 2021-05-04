package com.jackson.spring.files.csv.springbootuploadcsv.repository;

import com.jackson.spring.files.csv.springbootuploadcsv.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository <Tutorial, Long> {
}
