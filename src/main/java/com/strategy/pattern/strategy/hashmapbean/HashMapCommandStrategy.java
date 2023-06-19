package com.strategy.pattern.strategy.hashmapbean;

import com.strategy.pattern.dto.ExecuteRequest;

public interface HashMapCommandStrategy {

     Integer execute(Integer firstValue,Integer secondValue);
     String getType();
}
