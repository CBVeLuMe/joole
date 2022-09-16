package com.itlize.joole.repository;

import com.itlize.joole.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<List<Project>> findByUserId(Integer userId);
}
