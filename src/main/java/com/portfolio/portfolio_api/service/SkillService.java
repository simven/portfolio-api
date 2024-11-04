package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.Skill;
import com.portfolio.portfolio_api.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

    public Skill createSkill(Skill skill) {
        return this.skillRepository.save(skill);
    }

    public Skill updateSkill(Skill skill, Skill newSkill) {
        skill.setName(newSkill.getName());
        skill.setDescription(newSkill.getDescription());
        skill.setSkillType(newSkill.getSkillType());
        skill.setMasteryPercent(newSkill.getMasteryPercent());
        skill.setIconUrl(newSkill.getIconUrl());
        skill.setDisplay(newSkill.isDisplay());
        return this.skillRepository.save(skill);
    }

    public void deleteSkill(Skill skill) {
        this.skillRepository.delete(skill);
    }
}
