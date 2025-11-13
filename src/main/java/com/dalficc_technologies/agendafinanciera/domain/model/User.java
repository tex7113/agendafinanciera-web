package com.dalficc_technologies.agendafinanciera.domain.model;

import lombok.Data;

@Data
public class User {

    private String name;
    private String email;
    private String password;
    private Double availableAmount;
    private Double moneySaved;
    private Long createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getMoneySaved() {
        return moneySaved;
    }

    public void setMoneySaved(Double moneySaved) {
        this.moneySaved = moneySaved;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
