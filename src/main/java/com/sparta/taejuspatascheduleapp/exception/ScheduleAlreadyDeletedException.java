package com.sparta.taejuspatascheduleapp.exception;

public class ScheduleAlreadyDeletedException extends RuntimeException {
    public ScheduleAlreadyDeletedException(String message) {
        super(message);
    }
}
