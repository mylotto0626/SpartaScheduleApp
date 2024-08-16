package com.sparta.taejuspatascheduleapp.entity;

import com.sparta.taejuspatascheduleapp.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String listTitle;

    @Column
    @Length(max = 10)
    private String username;

    @Column
    @Length(max =255)
    private String content;

    @Column(length = 30, nullable = false)
    @NotNull
    private String password;

    @Column
    @NotNull
    private LocalDateTime created_at;

    public void update(ScheduleRequestDto requestDto) {
        if (requestDto.getListTitle() != null && !requestDto.getListTitle().isBlank()) {
            this.listTitle = requestDto.getListTitle();
        }

        if (requestDto.getContent() != null && !requestDto.getContent().isBlank()) {
            this.content = requestDto.getContent();
        }

        if (requestDto.getPassword() != null && !requestDto.getPassword().isBlank()) {
            this.password = requestDto.getPassword();
        }

        if (requestDto.getUsername() != null && !requestDto.getUsername().isBlank()) {
            this.username = requestDto.getUsername();
        }
    }

    private boolean isDeleted = false;

    public void setDeleted(boolean isDeleted) {
        this.isDeleted= isDeleted;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
}
