package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.DTO.EmailDTO;
import com.portfolio.portfolio_api.entity.Configuration;
import com.portfolio.portfolio_api.repository.ConfigurationRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final ConfigurationRepository configurationRepository;
    private final WebClient webClient;


    public EmailService(JavaMailSender mailSender, ConfigurationRepository configurationRepository, WebClient.Builder webClientBuilder) {
        this.mailSender = mailSender;
        this.configurationRepository = configurationRepository;
        this.webClient = webClientBuilder.baseUrl("https://www.google.com/recaptcha/api").build();
    }

    public Mono<String> sendEmail(EmailDTO emailDTO, String token) {
        return recaptchaVerified(token).flatMap(isVerified -> {
            if (isVerified) {
                // Si le reCAPTCHA est validé, envoyer l'email
                Configuration toEmail = this.configurationRepository.findByName("TO_EMAIL");
                Configuration from = this.configurationRepository.findByName("FROM_EMAIL");

                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(toEmail.getValue());
                message.setSubject("Nouveau message de " + emailDTO.getName());
                message.setText(emailDTO.getMessage());
                message.setReplyTo(emailDTO.getEmail());
                message.setFrom(emailDTO.getName() + "<" + from.getValue() + ">");

                mailSender.send(message);
                return Mono.just("Email envoyé !");
            } else {
                // Si le reCAPTCHA échoue, retourner un message d'erreur
                return Mono.just("Échec de la vérification reCAPTCHA.");
            }
        });
    }

    private Mono<Boolean> recaptchaVerified(String token) {
        String secretKey = this.configurationRepository.findByName("CAPTCHA_SECRET_KEY").getValue();

        return this.webClient
                .get()
                .uri("/siteverify?secret={secretKey}&response={token}", secretKey, token)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Boolean) response.get("success"));
    }
}
