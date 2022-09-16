package com.itlize.joole.service.impl;

import com.itlize.joole.entity.ProjectProduct;
import com.itlize.joole.repository.ProjectProductRepository;
import com.itlize.joole.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {
    @Autowired
    private ProjectProductRepository repository;

    @Override
    public List<ProjectProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectProduct findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectProduct> findByProjectId(Integer projectId) {
        return repository.findProjectProductByProjectId(projectId);
    }

    @Override
    public List<ProjectProduct> findByProductId(Integer productId) {
        return repository.findProjectProductByProductId(productId);
    }

    @Override
    public ProjectProduct save(ProjectProduct projectProduct) {
        return repository.save(projectProduct);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
