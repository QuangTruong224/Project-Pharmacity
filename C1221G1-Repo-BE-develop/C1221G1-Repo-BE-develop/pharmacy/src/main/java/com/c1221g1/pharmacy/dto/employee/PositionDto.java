package com.c1221g1.pharmacy.dto.employee;

import javax.validation.constraints.NotNull;

public class PositionDto {
    @NotNull(message = "Position may not be null")
    private Integer positionId;
    private String positionName;

    public PositionDto() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }


}