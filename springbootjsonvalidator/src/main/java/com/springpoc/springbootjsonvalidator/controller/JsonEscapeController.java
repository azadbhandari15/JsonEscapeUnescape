package com.springpoc.springbootjsonvalidator.controller;

import com.springpoc.springbootjsonvalidator.service.JsonEscapeUnescapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonEscapeController {


    @PostMapping("/escapejson")
    public ResponseEntity<String> escapeJson(@RequestBody String json) {
        return new ResponseEntity<>(JsonEscapeUnescapeService.escapeJson(json), HttpStatus.OK);
    }

    @PostMapping("/unescapejson")
    public ResponseEntity<?> unescapeJson(@RequestBody String json) {
        return new ResponseEntity<>(JsonEscapeUnescapeService.unescapeJson(json), HttpStatus.OK);
    }
}
