package com.itlize.joole.repository;

import com.itlize.joole.entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {
    List<ProjectProduct> findProjectProductByProjectId(Integer projectId);

    List<ProjectProduct> findProjectProductByProductId(Integer productId);
}
