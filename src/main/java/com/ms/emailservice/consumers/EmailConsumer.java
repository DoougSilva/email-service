package com.ms.emailservice.consumers;

import com.ms.emailservice.dtos.EmailDto;
import com.ms.emailservice.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    public final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public EmailDto listen(@Payload EmailDto emailDto) {
        return emailService.sendEmail(emailDto);
    }
}
