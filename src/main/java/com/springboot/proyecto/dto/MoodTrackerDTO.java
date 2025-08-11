package com.springboot.proyecto.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record MoodTrackerDTO(
    @NotBlank(message = "Ingresar nivel")
    @Min(1)
    @Max(5)
    int moodLevel,

    String note,

    LocalDate date
) {

}
