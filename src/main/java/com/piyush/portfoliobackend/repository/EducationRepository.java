package com.piyush.portfoliobackend.repository;

import com.piyush.portfoliobackend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByOrderByDisplayOrderAsc();
}
