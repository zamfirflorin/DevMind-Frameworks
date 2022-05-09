package controller;

import model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    private static final String AUTH = "authentication";
    private static final String API_KEY = "devmind-api-key";

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Message> postMessages(
            @RequestBody Message message,
            @RequestHeader(value = AUTH) String header) {

        if (header.equals(API_KEY)) {
            return new ResponseEntity(message, HttpStatus.CREATED);
        }
        return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }



}
