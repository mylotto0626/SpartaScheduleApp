package controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    // 일정 등록
    @PostMapping("/add")
    public String addSchedule() {
        return "일정 추가";
    }

    // 일정 전체 목록 조회
    @GetMapping("/list")
    public String getList() {
        return "전체 목록 조회";
    }

    // 선택한 일정 조회
    @GetMapping("/list/id")
    public String selectSchedule() {
        return "선택한 일정 조회";
    }

    // 선택한 일정 수정
    @PutMapping("/list/id")
    public String putSchedule() {
        return "선태한 일정 수정";
    }

    // 선택한 일정 수정
    @DeleteMapping("/list/id")
    public String deleteSchedule() {
        return "선태한 일정 삭제";
    }
}
