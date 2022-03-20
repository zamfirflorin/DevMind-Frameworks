package com.example.curs7_di_beanscope_lifecycle;

import org.springframework.stereotype.Component;

@Component
public class FrameworkKnowledge implements ITeachingService {

    @Override
    public String teachSomething() {
        return "Frameworks are your friend, not your enemy!";
    }
}