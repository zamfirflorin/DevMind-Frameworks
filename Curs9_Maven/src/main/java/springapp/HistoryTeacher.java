package springapp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class HistoryTeacher implements ITeacher{

    @Override
    public String getHomework() {
        return "Learn about WW1";
    }

    @Override
    public String getWisdom() {
        return null;
    }

}
