package com.itlize.joole.service;

import com.itlize.joole.entity.ProjectProduct;

import java.util.List;

public interface ProjectProductService {
    List<ProjectProduct> findAll();

    ProjectProduct findById(Integer id);

    List<ProjectProduct> findByProjectId(Integer projectId);

    List<ProjectProduct> findByProductId(Integer productId);

    ProjectProduct save(ProjectProduct projectProduct);

    void deleteById(Integer id);
}
