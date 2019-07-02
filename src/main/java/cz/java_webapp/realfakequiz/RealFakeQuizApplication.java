package cz.java_webapp.realfakequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring4.*;
import org.thymeleaf.spring4.view.*;
import org.thymeleaf.templateresolver.*;

@SpringBootApplication
public class RealFakeQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealFakeQuizApplication.class, args);
    }

}
