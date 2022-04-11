package exercitii;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Curs;

import java.io.File;
import java.io.IOException;

public class Exercitiu1 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPath = "/resoursces/example.json";
        Curs curs =  objectMapper.readValue(new File("src/main/resources/example.json"), Curs.class);


    }

}
