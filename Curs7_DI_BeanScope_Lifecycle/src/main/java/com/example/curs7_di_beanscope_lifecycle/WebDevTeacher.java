package com.example.curs7_di_beanscope_lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component()
@Scope("prototype")
public class WebDevTeacher implements DisposableBean {

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> WebDevTeacher: inside doMyStartupStuff()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">> WebDevTeacher: inside destroy()");
    }
}