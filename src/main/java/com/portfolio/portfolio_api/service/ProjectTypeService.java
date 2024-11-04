package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.ProjectType;
import com.portfolio.portfolio_api.repository.ProjectTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeService {
    private final ProjectTypeRepository projectTypeRepository;

    public ProjectTypeService(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    public List<ProjectType> getProjectTypes() {
        return this.projectTypeRepository.findAll();
    }

    public ProjectType createProjectType(ProjectType projectType) {
        return this.projectTypeRepository.save(projectType);
    }
}
