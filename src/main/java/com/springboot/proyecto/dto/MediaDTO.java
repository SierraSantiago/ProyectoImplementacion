package com.springboot.proyecto.dto;

import com.springboot.proyecto.models.MediaType;
import jakarta.validation.constraints.NotBlank;

public record MediaDTO(
    @NotBlank
    MediaType media,

    @NotBlank
    String url,

    String caption
) {

}
