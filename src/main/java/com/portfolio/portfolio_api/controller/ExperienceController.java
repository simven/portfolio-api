package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.Experience;
import com.portfolio.portfolio_api.service.ExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/experience")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getExperiences() {
        return this.experienceService.getExperiences();
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return this.experienceService.createExperience(experience);
    }

    @PutMapping("/{experience}")
    public Experience updateExperience(@PathVariable Experience experience, @RequestBody Experience newExperience) {
        return this.experienceService.updateExperience(experience, newExperience);
    }

    @DeleteMapping("/{experience}")
    public void deleteExperience(@PathVariable Experience experience) {
        this.experienceService.deleteExperience(experience);
    }
}
