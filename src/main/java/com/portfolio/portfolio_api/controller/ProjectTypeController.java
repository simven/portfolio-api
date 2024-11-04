package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.ProjectType;
import com.portfolio.portfolio_api.service.ProjectTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/project-type")
public class ProjectTypeController {
    private final ProjectTypeService projectTypeService;

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping
    public List<ProjectType> getProjectTypes() {
        return this.projectTypeService.getProjectTypes();
    }

    @PostMapping
    public ProjectType createProjectType(@RequestBody ProjectType projectType) {
        return this.projectTypeService.createProjectType(projectType);
    }
}
