package edu.codeup.codeupspringblog.controllers;

public class AdController<EmailService> {
    private final EmailService emailService;

    public AdController(EmailService emailService) {
        this.emailService = emailService;
    }
}
