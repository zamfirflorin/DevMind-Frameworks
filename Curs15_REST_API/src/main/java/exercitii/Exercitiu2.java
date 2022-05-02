package exercitii;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Exercitiu2 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("C:\\Users\\FZAMFIR\\IdeaProjects\\DevMind-Frameworks\\Curs15_REST_API\\src\\main\\resources\\example.json");
        String json = Files.readAllLines(path)
                .stream()
                .reduce("", String::concat);
        System.out.println(json);
        JsonNode jsonNode = objectMapper.readTree(json);

        Map<String, Object> map
                = objectMapper.readValue(json, new TypeReference<>() {
        });

        System.out.println(map);

    }
}
