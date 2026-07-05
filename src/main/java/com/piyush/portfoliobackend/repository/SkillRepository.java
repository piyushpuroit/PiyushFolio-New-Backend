package com.piyush.portfoliobackend.repository;

import com.piyush.portfoliobackend.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByOrderByDisplayOrderAsc();
}
