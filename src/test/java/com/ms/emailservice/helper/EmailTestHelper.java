package com.ms.emailservice.helper;

import com.ms.emailservice.dtos.EmailDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailTestHelper {

    public EmailDto creteEmailDTO() {
        EmailDto emailDto = EmailDto.builder()
                .ownerRef("test")
                .emailFrom("emailfrom@email.com")
                .emailTo("emailto@email.com")
                .subject("Title Test")
                .text("Send Email Test!")
                .build();
        return emailDto;
    }
}
