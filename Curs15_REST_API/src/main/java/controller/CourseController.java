package controller;

import model.Curs;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Curs> postMessages(
            @RequestBody Curs curs,
            @RequestHeader(value = "authentication") String header) {

        if (header.equals("devmind-api-key")) {
            return new ResponseEntity(curs, HttpStatus.CREATED);
        }
        return new ResponseEntity(curs, HttpStatus.UNAUTHORIZED);
    }


}
