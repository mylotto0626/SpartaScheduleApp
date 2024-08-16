package com.sparta.taejuspatascheduleapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.taejuspatascheduleapp.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
   private Long id;
   private String listTitle;
   private String username;
   private String content;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created_at;

    public ScheduleResponseDto(Long id, String listTitle, String content, String username, LocalDateTime created_at) {
        this.id = id;
        this.listTitle = listTitle;
        this.content = content;
        this.username = username;
        this.created_at = created_at;
    }

    public static ScheduleResponseDto fromSchedule(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(),schedule.getListTitle(),schedule.getContent(),schedule.getUsername(),schedule.getCreated_at());
    }
}
