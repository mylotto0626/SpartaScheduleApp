package controller;


import dto.ScheduleRequestDto;
import dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;
import service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private ScheduleService scheduleService;

    private ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 등록
    @PostMapping("/add")
    public ScheduleRequestDto addSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.addSchedule(scheduleRequestDto);
    }

    // 일정 전체 목록 조회
    @GetMapping("/list")
    public List<ScheduleResponseDto> getList() {
        return scheduleService.getList();
    }

    // 선택한 일정 조회
    @GetMapping("/list/{id}")
    public ScheduleResponseDto selectSchedule(@PathVariable Long id) {
        return scheduleService.getSelectedSchedule(id);
    }

    // 선택한 일정 수정
    @PutMapping("/list/{id}")
    public ScheduleResponseDto putSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.putSchedule(id, scheduleRequestDto);
    }

    // 선택한 일정 삭제
    @DeleteMapping("/list/{id}")
    public void  deleteSchedule(@PathVariable Long id,@RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
    }
}
