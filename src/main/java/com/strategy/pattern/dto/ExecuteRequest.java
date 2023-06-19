package com.strategy.pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteRequest {

    private String type;
    private Integer firstValue;
    private Integer secondValue;

}
