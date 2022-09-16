package com.itlize.joole.service;

import com.itlize.joole.entity.ProjectProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectProductServiceTest {
    @Autowired
    private ProjectProductService service;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProductService productService;

    @Test
    void findAll() {
        Assertions.assertNotNull(service.findAll());
    }

    @Test
    void findById() {
        ProjectProduct projectProduct = new ProjectProduct();
        // To replace this method
        projectProduct.setProject(projectService.findById(3));
        projectProduct.setProduct(productService.findById(2));
        service.save(projectProduct);
        Assertions.assertNotNull(service.findById(projectProduct.getId()));
    }

    @Test
    void findProductsByProject() {
        Assertions.assertNotNull(service.findByProductId(2));
    }

    @Test
    void testFindProductsByProject() {
        Assertions.assertNotNull(service.findByProjectId(3));
    }

    @Test
    void save() {
        ProjectProduct projectProduct = new ProjectProduct();
        // To replace this method
        projectProduct.setProject(projectService.findById(3));
        projectProduct.setProduct(productService.findById(2));
        service.save(projectProduct);
        Assertions.assertNotNull(service.findById(projectProduct.getId()));
    }

    @Test
    void deleteById() {
        ProjectProduct projectProduct = new ProjectProduct();
        // To replace this method
        projectProduct.setProject(projectService.findById(3));
        projectProduct.setProduct(productService.findById(2));
        service.save(projectProduct);
        service.deleteById(projectProduct.getId());
        Assertions.assertNull(service.findById(projectProduct.getId()));
    }
}