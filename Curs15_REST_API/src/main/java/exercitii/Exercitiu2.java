package exercitii;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Curs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Exercitiu2 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("C:\\Users\\FZAMFIR\\IdeaProjects\\DevMind-Frameworks\\Curs15_REST_API\\src\\main\\resources\\example2.json");

        ArrayList<Curs> cursuri
                = objectMapper.readValue(new File("C:\\Users\\florin.zamfir\\IdeaProjects\\DevMind-Frameworks\\Curs15_REST_API\\src\\main\\resources\\example2.json"), new TypeReference<>() {
        });

        System.out.println(cursuri);

    }
}
