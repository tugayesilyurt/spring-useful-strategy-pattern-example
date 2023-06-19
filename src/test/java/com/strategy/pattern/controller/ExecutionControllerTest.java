package com.strategy.pattern.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strategy.pattern.dto.ExecuteRequest;
import com.strategy.pattern.strategy.hashmapbean.HashMapCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ExecutionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HashMapCommand hashMapCommand;

    @InjectMocks
    private ExecutionController executionController;

    @Test
    public void testExecuteEnumeration() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(executionController).build();

        ExecuteRequest executeRequest = new ExecuteRequest("Addition", 10, 5);
        Integer expectedResult = 15;

        Mockito.when(hashMapCommand.process(Mockito.any(ExecuteRequest.class))).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/execute/enumeration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(executeRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(expectedResult));
    }

    @Test
    public void testExecuteHashMap() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(executionController).build();

        ExecuteRequest executeRequest = new ExecuteRequest("HashMapBean", 10, 5);
        Integer expectedResult = 15;

        Mockito.when(hashMapCommand.process(Mockito.any(ExecuteRequest.class))).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/execute/hashmapbean")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(executeRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(expectedResult));
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

