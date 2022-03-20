package com.example.curs7_di_beanscope_lifecycle;

import org.springframework.stereotype.Component;

@Component
public class TipsAndTrickService implements ITeachingService {

    @Override
    public String teachSomething() {
        return "Always be thorough and learn from your mistakes!";
    }
}
