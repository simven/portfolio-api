package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.SkillType;
import com.portfolio.portfolio_api.repository.SkillTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeService {
    private final SkillTypeRepository skillTypeRepository;

    public SkillTypeService(SkillTypeRepository skillTypeRepository) {
        this.skillTypeRepository = skillTypeRepository;
    }

    public List<SkillType> getSkillTypes() {
        return this.skillTypeRepository.findAll();
    }

    public SkillType createSkillType(SkillType skillType) {
        return this.skillTypeRepository.save(skillType);
    }
}
