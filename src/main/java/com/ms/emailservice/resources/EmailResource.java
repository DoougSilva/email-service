package com.ms.emailservice.resources;

import com.ms.emailservice.consumers.EmailConsumer;
import com.ms.emailservice.dtos.EmailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailResource {

    private final EmailConsumer emailConsumer;

    public EmailResource(EmailConsumer emailConsumer) {
        this.emailConsumer = emailConsumer;
    }

    @PostMapping("/sending-email")
    public ResponseEntity<EmailDto> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emailConsumer.listen(emailDto));
    }
}
