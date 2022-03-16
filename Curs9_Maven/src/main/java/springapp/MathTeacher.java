package springapp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MathTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    private static final String MATH_TEACHER_PREFIX = "Math teacher says: ";
    @Override
    public String getHomework() {
        return "Solve 100 calculus problems";
    }

    @Override
    public String getWisdom() {
        return MATH_TEACHER_PREFIX + wisdomService.getMessage();
    }

    public void setWisdomService(WisdomWordsService wisdomSevice) {
        this.wisdomService = wisdomSevice;
    }
}
