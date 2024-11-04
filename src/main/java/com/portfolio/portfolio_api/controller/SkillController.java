package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.Skill;
import com.portfolio.portfolio_api.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getSkills() {
        return this.skillService.getSkills();
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return this.skillService.createSkill(skill);
    }

    @PutMapping("/{skill}")
    public Skill updateSkill(@PathVariable Skill skill, @RequestBody Skill newSkill) {
        return this.skillService.updateSkill(skill, newSkill);
    }

    @DeleteMapping("/{skill}")
    public void deleteSkill(@PathVariable Skill skill) {
        this.skillService.deleteSkill(skill);
    }
}
