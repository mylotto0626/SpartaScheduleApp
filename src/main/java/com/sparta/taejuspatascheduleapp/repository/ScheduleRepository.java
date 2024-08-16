package com.sparta.taejuspatascheduleapp.repository;

import com.sparta.taejuspatascheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
