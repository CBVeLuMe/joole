package com.itlize.joole.service;

import com.itlize.joole.entity.Project;
import com.itlize.joole.entity.enums.ProjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService service;
    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        Assertions.assertNotNull(service.findAll());
    }

    @Test
    void findById() {
        Project project = new Project();
        project.setName("junit_test");
        project.setAddress("ad");
        project.setType(ProjectType.placeholder);
        project.setSize(123);
        project.setUser(userService.findById(1));
        service.save(project);
        Assertions.assertNotNull(service.findById(project.getId()));
    }

    @Test
    void findByUserId() {
        Integer userId = 1;
//        System.out.println(service.findByUserId(userId));
//        Assertions.assertEquals(service.findByUserId(userId), ;
        Assertions.assertNotNull(service.findByUserId(userId));
    }

    @Test
    void save() {
        Project project = new Project();
        project.setName("junit_test");
        project.setAddress("ad");
        project.setType(ProjectType.placeholder);
        project.setSize(123);
        project.setUser(userService.findById(1));
        service.save(project);
        Assertions.assertNotNull(service.findById(project.getId()));
    }

    @Test
    void deleteById() {
        Project project = new Project();
        project.setName("junit_test");
        project.setAddress("ad");
        project.setType(ProjectType.placeholder);
        project.setSize(123);
        project.setUser(userService.findById(1));
        service.save(project);
        service.deleteById(project.getId());
        Assertions.assertNull(service.findById(project.getId()));
    }
}