package com.portfolio.portfolio_api.controller;

import com.portfolio.portfolio_api.DTO.EmailDTO;
import com.portfolio.portfolio_api.service.EmailService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody EmailDTO emailDTO, @RequestParam String token) throws Exception {
        this.emailService.sendEmail(emailDTO, token);
    }
}
