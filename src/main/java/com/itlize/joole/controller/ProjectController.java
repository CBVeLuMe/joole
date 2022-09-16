package com.itlize.joole.controller;

import com.itlize.joole.entity.Project;
import com.itlize.joole.entity.enums.ProjectType;
import com.itlize.joole.service.ProjectService;
import com.itlize.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping("/projects")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") Integer id) {
        Project project = projectService.findById(id);
        if (project == null) {
            return new ResponseEntity<>("Cannot find project id " + id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<?> create(@RequestParam(name = "name",
            defaultValue = "New Project", required = false) String name,
                                    @RequestParam(name = "address", required = false) String address,
                                    @RequestParam(name = "type", required = false) ProjectType type,
                                    @RequestParam(name = "size", required = false) Integer size,
                                    @RequestParam(name = "userId") Integer userId) {
        Project project = new Project();
        project.setName(name);
        project.setAddress(address);
        project.setType(type);
        project.setSize(size);
        // Use security method instead for next
        project.setUser(userService.findById(userId));
        projectService.save(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        projectService.deleteById(id);
    }

    @GetMapping("/readProjectsFromUser")
    public ResponseEntity<?> readProjectsFromUser(@RequestParam("userId") Integer userId) {
        List<Project> projects = projectService.findByUserId(userId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
