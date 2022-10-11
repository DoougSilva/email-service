package com.ms.emailservice.entities;

import com.ms.emailservice.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_email")
public class EmailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;

    @Column
    private String ownerRef;

    @Column
    private String emailFrom;

    @Column
    private String emailTo;

    @Column
    private String subject;

    @Column
    private String text;

    @Column
    private LocalDateTime sendDateEmail;

    @Column
    private StatusEmail statusEmail;
}
