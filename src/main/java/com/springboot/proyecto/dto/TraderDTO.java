package com.springboot.proyecto.dto;

import com.springboot.proyecto.models.TraderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TraderDTO(
        @NotNull(message = "El tipo es obligatorio")
        TraderType type,

        @NotBlank(message = "La URL no puede estar vacía")
        String url,

        @NotBlank(message = "El caption no puede estar vacío")
        String caption,

        @NotNull(message = "Se requiere el ID del revenge plan")
        Long revengePlanId
) {
}
