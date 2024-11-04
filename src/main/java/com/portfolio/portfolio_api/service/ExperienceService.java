package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.Experience;
import com.portfolio.portfolio_api.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getExperiences() {
        return this.experienceRepository.findAll();
    }

    public Experience createExperience(Experience experience) {
        return this.experienceRepository.save(experience);
    }

    public Experience updateExperience(Experience experience, Experience newExperience) {
        experience.setName(newExperience.getName());
        experience.setContract(newExperience.getContract());
        experience.setFromDate(newExperience.getFromDate());
        experience.setToDate(newExperience.getToDate());
        experience.setCompany(newExperience.getCompany());
        experience.setLocation(newExperience.getLocation());
        experience.setStatus(newExperience.getStatus());
        experience.setWork(newExperience.isWork());
        experience.setCurrent(newExperience.isCurrent());
        experience.setDisplay(newExperience.isDisplay());
        return this.experienceRepository.save(experience);
    }

    public void deleteExperience(Experience experience) {
        this.experienceRepository.delete(experience);
    }
}
