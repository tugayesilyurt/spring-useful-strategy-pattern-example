package com.strategy.pattern.controller;

import com.strategy.pattern.dto.ExecuteRequest;
import com.strategy.pattern.strategy.enumeration.EnumerationCommand;
import com.strategy.pattern.strategy.hashmapbean.HashMapCommand;
import com.strategy.pattern.strategy.hashmapbean.HashMapCommandStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/execute")
@RequiredArgsConstructor
public class ExecutionController {

    private final HashMapCommand hashMapCommand;

    @PostMapping(value = "/enumeration")
    public ResponseEntity<?> executeEnumeration(@RequestBody ExecuteRequest executeRequest){

        Integer result = EnumerationCommand.getEnumerationCommandType(executeRequest.getType()).
                execute(executeRequest.getFirstValue(),executeRequest.getSecondValue());

        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/hashmapbean")
    public ResponseEntity<?> executeHashMap(@RequestBody ExecuteRequest executeRequest){

        Integer result = hashMapCommand.process(executeRequest);

        return new ResponseEntity<Integer>(result, HttpStatus.OK);

    }

}
