package com.mozhoudonglu;

import com.mozhoudonglu.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springdemo02ApplicationTests {
@Autowired
private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
