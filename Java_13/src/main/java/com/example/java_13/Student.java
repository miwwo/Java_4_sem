package com.example.java_13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Student {

 private final Environment environment;

 @Value("${program.student.name}")
 private String name;

 @Value("${program.student.last_name}")
 private String last_name;

 @Value("${program.student.group}")
 private String group;

 public Student(Environment environment) {
  this.environment = environment;
 }

 @PostConstruct
 public void init() {
  String name_env = environment.getProperty("program.student.name");
  System.out.println("Hello! I'm " + name_env);
  System.out.println("This program is written by " + last_name + " " + name + " from group " + group);
 }
}
