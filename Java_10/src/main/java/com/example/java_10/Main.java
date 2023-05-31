package com.example.java_10;
/*
Создать приложение, в котором создается ApplicationContext и из него
берётся бин с названием, переданным в качестве аргумента к приложению, и
вызывается метод интерфейса, который он имплементирует. Нужно создать
по одному бину для каждого класса, определить им название. Проверить, что
вызывается при вводе названия каждого из бинов. Классы и интерфейс
определяются в соответствии с вариантом индивидуального задания.

5) Интерфейс Musician с методом doCoding(), его имплементации:
Drummer, guitarist, trombonist
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface Musician {
    void doMusic();
}

@Component
class Drummer implements Musician {

    @Override
    public void doMusic() {
        System.out.println("Drummer is playing music!");
    }
}

@Component
class Guitarist implements Musician {

    @Override
    public void doMusic() {
        System.out.println("Guitarist is playing music!");
    }
}

@Component
class Trombonist implements Musician {

    @Override
    public void doMusic() {
        System.out.println("Trombonist is playing music!");
    }
}

@Configuration
@ComponentScan
class BeanConfig {

    @Bean(name = "drummer")
    public Musician drummer() {
        return new Drummer();
    }

    @Bean(name = "guitarist")
    public Musician guitarist() {
        return new Guitarist();
    }

    @Bean(name = "trombonist")
    public Musician trombonist() {
        return new Trombonist();
    }
}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Musician musician_1 = (Musician) context.getBean("drummer");
        Musician musician_2 = (Musician) context.getBean("guitarist");
        Musician musician_3 = (Musician) context.getBean("trombonist");

        musician_1.doMusic();
        musician_2.doMusic();
        musician_3.doMusic();
    }
}