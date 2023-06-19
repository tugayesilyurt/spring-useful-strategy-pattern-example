package com.strategy.pattern.strategy.hashmapbean;

import com.strategy.pattern.dto.ExecuteRequest;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapCommand {

    private final Map<String, HashMapCommandStrategy> hashMapCommandStrategyMap = new HashMap<>();

    public HashMapCommand(ListableBeanFactory listOfBean) {
        listOfBean.getBeansOfType(HashMapCommandStrategy.class)
                .values()
                .forEach(service -> hashMapCommandStrategyMap.put(service.getType(), service));
    }

    public Integer process(ExecuteRequest executeRequest){
        return hashMapCommandStrategyMap.get(executeRequest.getType())
                .execute(executeRequest.getFirstValue(),executeRequest.getSecondValue());
    }

}
