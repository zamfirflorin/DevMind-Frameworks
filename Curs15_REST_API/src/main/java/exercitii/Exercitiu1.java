package exercitii;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Message;

import java.io.File;
import java.io.IOException;


public class Exercitiu1 {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(new File("Curs15_REST_API/src/main/resources/messages.json"), Message.class);
        System.out.println(message.toString());

    }
}
