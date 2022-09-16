package com.itlize.joole.controller;

import com.itlize.joole.entity.ProjectProduct;
import com.itlize.joole.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ProjectProductController {
    @Autowired
    private ProjectProductService service;

    @GetMapping("/readProjectProduct")
    public List<ProjectProduct> readProjectProduct() {
        return service.findAll();
    }
}
