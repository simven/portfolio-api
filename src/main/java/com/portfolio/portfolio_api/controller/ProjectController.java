package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.Project;
import com.portfolio.portfolio_api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return this.projectService.getProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return this.projectService.createProject(project);
    }

    @PutMapping("/{project}")
    public Project updateProject(@PathVariable Project project, @RequestBody Project newProject) {
        return this.projectService.updateProject(project, newProject);
    }

    @DeleteMapping("/{project}")
    public void deleteProject(@PathVariable Project project) {
        this.projectService.deleteProject(project);
    }
}
