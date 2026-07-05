package com.piyush.portfoliobackend.repository;

import com.piyush.portfoliobackend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
