package service;

import dto.ScheduleRequestDto;
import dto.ScheduleResponseDto;
import entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private ScheduleRepository ScheduleRepository;

    public ScheduleRequestDto addSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule();
        return  scheduleRequestDto;
    }


    public List<ScheduleResponseDto> getList() {
       return null;
    }

    public ScheduleResponseDto getSelectedSchedule(Long id){
        System.out.println("선택된 스케줄");
        return null;
    }

    public ScheduleResponseDto putSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        return null;
    }

    public void deleteSchedule(Long id, String password) {

    }
}
