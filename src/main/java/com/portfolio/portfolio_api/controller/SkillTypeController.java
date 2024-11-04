package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.SkillType;
import com.portfolio.portfolio_api.service.SkillTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/skill-type")
public class SkillTypeController {
    private final SkillTypeService skillTypeService;

    public SkillTypeController(SkillTypeService skillTypeService) {
        this.skillTypeService = skillTypeService;
    }

    @GetMapping
    public List<SkillType> getSkillTypes() {
        return this.skillTypeService.getSkillTypes();
    }

    @PostMapping
    public SkillType createSkillType(@RequestBody SkillType skillType) {
        return this.skillTypeService.createSkillType(skillType);
    }
}
