package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.Project;
import com.portfolio.portfolio_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return this.projectRepository.save(project);
    }

    public Project updateProject(Project project, Project newProject) {
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        project.setDescriptionShort(newProject.getDescriptionShort());
        project.setFromDate(newProject.getFromDate());
        project.setToDate(newProject.getToDate());
        project.setAppUrl(newProject.getAppUrl());
        project.setRepoUrl(newProject.getRepoUrl());
        project.setIconUrl(newProject.getRepoUrl());
        project.setImageUrl(newProject.getImageUrl());
        project.setDisplay(newProject.isDisplay());
        project.setProjectType(newProject.getProjectType());
        project.setSkills(newProject.getSkills());
        return this.projectRepository.save(project);
    }

    public void deleteProject(Project project) {
        this.projectRepository.delete(project);
    }
}
