package me.approximations.springExample.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCategoryDTO(
        @NotNull(message="Name cannot be null") @NotBlank(message="Name cannot be empty") String name) {
}
