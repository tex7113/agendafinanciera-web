package com.dalficc_technologies.agendafinanciera.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Expense {

    private String id; // generado en backend

    @Min(value = 1, message = "El monto debe ser mayor a 0")
    private double amount;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    private String date;

    private Long notificationTimestamp;

    private Boolean notified;

    private Boolean paid;

    private Boolean remember;

    @NotNull(message = "La fecha es obligatoria")
    private String createdAt;
}
