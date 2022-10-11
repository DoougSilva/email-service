package com.ms.emailservice.service;

import com.ms.emailservice.dtos.EmailDto;
import com.ms.emailservice.entities.EmailEntity;
import com.ms.emailservice.enums.StatusEmail;
import com.ms.emailservice.helper.EmailTestHelper;
import com.ms.emailservice.repositories.EmailRepository;
import com.ms.emailservice.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmailServiceUnitTest {

    private EmailService emailService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private JavaMailSender emailSender;

    private EmailDto emailDto;

    private ArgumentCaptor<EmailEntity> emailCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        emailService = spy(new EmailService(emailRepository, emailSender));
        emailCaptor = ArgumentCaptor.forClass(EmailEntity.class);

        emailDto = EmailTestHelper.creteEmailDTO();
    }

    @Test
    public void shouldSavedAndSendingEmail() {
        emailService.sendEmail(emailDto);
        verify(emailRepository, times(1)).save(emailCaptor.capture());
        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));
        assertEquals(StatusEmail.SENT, emailCaptor.getValue().getStatusEmail());
    }
}
