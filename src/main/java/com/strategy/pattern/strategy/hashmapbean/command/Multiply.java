package com.strategy.pattern.strategy.hashmapbean.command;

import com.strategy.pattern.strategy.hashmapbean.HashMapCommandStrategy;
import org.springframework.stereotype.Component;

@Component
public class Multiply implements HashMapCommandStrategy {
    @Override
    public Integer execute(Integer firstValue, Integer secondValue) {

        return firstValue * secondValue;
    }

    @Override
    public String getType() {
        return "Multiply";
    }
}
