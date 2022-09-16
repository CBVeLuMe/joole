package com.itlize.joole.service;

import com.itlize.joole.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();

    Project findById(Integer id);

    Project save(Project project);

    void deleteById(Integer id);

    List<Project> findByUserId(Integer userId);
}
