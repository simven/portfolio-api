package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.Hobby;
import com.portfolio.portfolio_api.repository.HobbyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {
    private final HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public List<Hobby> getHobbies() {
        return this.hobbyRepository.findAll();
    }

    public Hobby createHobby(Hobby hobby) {
        return this.hobbyRepository.save(hobby);
    }

    public Hobby updateHobby(Hobby hobby, Hobby newHobby) {
        hobby.setName(newHobby.getName());
        hobby.setIcon(newHobby.getIcon());
        hobby.setDisplay(newHobby.isDisplay());
        return this.hobbyRepository.save(hobby);
    }

    public void deleteHobby(Hobby hobby) {
        this.hobbyRepository.delete(hobby);
    }
}
