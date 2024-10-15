package com.nt.Entity;


import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 250)
    private String description;

    @Column(nullable = false)
    private Boolean isCompleted = false;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
