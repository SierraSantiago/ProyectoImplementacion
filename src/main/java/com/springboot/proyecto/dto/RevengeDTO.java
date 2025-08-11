package com.springboot.proyecto.dto;

import jakarta.validation.constraints.NotBlank;

public record RevengeDTO(
    @NotBlank
    String title,

    String description,

    boolean isExecuted

) {

}
