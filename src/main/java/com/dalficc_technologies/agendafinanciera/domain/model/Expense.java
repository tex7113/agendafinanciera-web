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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getNotified() {
        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }

    public Long getNotificationTimestamp() {
        return notificationTimestamp;
    }

    public void setNotificationTimestamp(Long notificationTimestamp) {
        this.notificationTimestamp = notificationTimestamp;
    }

    private Long notificationTimestamp;

    private Boolean notified;

    private Boolean paid;

    private Boolean remember;

    @NotNull(message = "La fecha es obligatoria")
    private String createdAt;
}
