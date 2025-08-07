package com.springboot.proyecto.dto;

import jakarta.validation.constraints.NotBlank;

public record CliqueDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String name,
        @NotBlank(message = "La descripción no puede estar vacía")
        String description
) {
}
