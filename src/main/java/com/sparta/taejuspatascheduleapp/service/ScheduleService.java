package com.sparta.taejuspatascheduleapp.service;

import com.sparta.taejuspatascheduleapp.dto.ScheduleRequestDto;
import com.sparta.taejuspatascheduleapp.dto.ScheduleResponseDto;
import com.sparta.taejuspatascheduleapp.entity.Schedule;
import com.sparta.taejuspatascheduleapp.exception.PasswordMismatchException;
import com.sparta.taejuspatascheduleapp.exception.ScheduleAlreadyDeletedException;
import com.sparta.taejuspatascheduleapp.exception.ScheduleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sparta.taejuspatascheduleapp.repository.ScheduleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private ScheduleRepository ScheduleRepository;


    // 일정 추가
    public ScheduleResponseDto addSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule();
        schedule.setListTitle(scheduleRequestDto.getListTitle());
        schedule.setContent(scheduleRequestDto.getContent());
        schedule.setUsername(scheduleRequestDto.getUsername());
        schedule.setPassword(scheduleRequestDto.getPassword());
        schedule.setCreated_at(LocalDateTime.now());

        ScheduleRepository.save(schedule);
        return ScheduleResponseDto.fromSchedule(schedule);
    }

    // 전체 일정 조회
    public List<ScheduleResponseDto> getList() {
       List<Schedule> schedules = ScheduleRepository.findAll();
       return schedules.stream().map(ScheduleResponseDto::fromSchedule).collect(Collectors.toList());
    }

    // 선택한 일정 조회
    public ScheduleResponseDto getSelectedSchedule(Long id){
        Schedule schedule = ScheduleRepository.findById(id).orElseThrow(()->new ScheduleNotFoundException("일정을 찾을 수 없습니다"));
        return ScheduleResponseDto.fromSchedule(schedule);
    }


    // 선택한 일정 수정
    @Transactional
    public ScheduleResponseDto putSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = ScheduleRepository.findById(id)
                .orElseThrow(()->new ScheduleNotFoundException("일정을 찾을 수 없습니다"));

        if(!Objects.equals(schedule.getPassword(), scheduleRequestDto.getPassword())) {
            System.out.println("비밀번호가 일치하지 않습니다");
        }

        schedule.update(scheduleRequestDto);
        return ScheduleResponseDto.fromSchedule(schedule);
    }


    // 선택한 일정 삭제
    @Transactional
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = ScheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("일정을 찾을 수 없습니다. ID: " + id));

        if (!schedule.getPassword().equals(password)) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        if (schedule.isDeleted()) {
            throw new ScheduleAlreadyDeletedException("이미 삭제된 일정입니다. ID: " + id);
        }

        schedule.setDeleted(true);
        ScheduleRepository.save(schedule);

    }


}
