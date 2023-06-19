package com.strategy.pattern.dto;

import lombok.Data;

@Data
public class ExecuteRequest {

    private String type;
    private Integer firstValue;
    private Integer secondValue;

}
