package com.piyush.portfoliobackend.repository;

import com.piyush.portfoliobackend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findAllByOrderByDisplayOrderAsc();
}
