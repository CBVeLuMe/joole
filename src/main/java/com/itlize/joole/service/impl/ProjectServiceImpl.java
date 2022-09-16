package com.itlize.joole.service.impl;

import com.itlize.joole.entity.Project;
import com.itlize.joole.repository.ProjectRepository;
import com.itlize.joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findByUserId(Integer userId) {
        return projectRepository.findByUserId(userId).orElse(null);
    }
}
