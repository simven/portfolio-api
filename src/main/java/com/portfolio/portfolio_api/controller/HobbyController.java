package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.entity.Hobby;
import com.portfolio.portfolio_api.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hobby")
public class HobbyController {
    private final HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping
    public List<Hobby> getHobbies() {
        return this.hobbyService.getHobbies();
    }

    @PostMapping
    public Hobby createHobby(@RequestBody Hobby hobby) {
        return this.hobbyService.createHobby(hobby);
    }

    @PutMapping("/{hobby}")
    public Hobby updateHobby(@PathVariable Hobby hobby, @RequestBody Hobby newHobby) {
        return this.hobbyService.updateHobby(hobby, newHobby);
    }

    @DeleteMapping("/{hobby}")
    public void deleteHobby(@PathVariable Hobby hobby) {
        this.hobbyService.deleteHobby(hobby);
    }
}
