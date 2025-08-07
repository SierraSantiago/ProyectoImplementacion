package com.springboot.proyecto.dto;

import com.springboot.proyecto.models.HighSchoolRole;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BullyDTO(
        String name,
        String nickname,

        @NotNull(message = "El rol en la escuela es obligatorio")
        HighSchoolRole highSchoolRole,

        String bullyingReason,

        @Min(1)
        @Max(10)
        int levelOfAnnoyance,

        @NotNull(message = "Debe especificarse el ID del clique")
        Long cliqueId
) {
}
