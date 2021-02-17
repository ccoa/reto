package com.entelgy.reto.controller;

import com.entelgy.reto.service.TransformerService;
import com.entelgy.reto.util.DataResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("transformers")
@RestController
@AllArgsConstructor
public class TransformerController {

    private final TransformerService transformerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<DataResponse> transformData() {
        return new ResponseEntity<>(transformerService.getTransformedData(), HttpStatus.OK);
    }

}
