package com.entelgy.reto.service;

import com.entelgy.reto.controller.TransformerController;
import com.entelgy.reto.util.DataResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TransformerServiceTest {

    private TransformerController controller;
    private TransformerService service;

    private DataResponse dataResponse;

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(TransformerService.class);
        controller = new TransformerController(service);
        dataResponse = new DataResponse();
        dataResponse.addItemData("1\\1\\Eliseo@gardner.biz");
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
        Mockito.when(service.getTransformedData()).thenReturn(dataResponse);
        ResponseEntity<DataResponse> httpResponse = controller.transformData();

        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(dataResponse, httpResponse.getBody());
    }

}
