package com.ciencuadras.crm.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> validationFilds(MethodArgumentNotValidException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("response", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return ResponseEntity.ok(map);
    }
}
