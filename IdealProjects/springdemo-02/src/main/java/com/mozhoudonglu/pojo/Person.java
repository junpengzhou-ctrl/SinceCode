package com.mozhoudonglu.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private int age;
    private String name;
    private Date date;
    private Map<String,Object> maps;
    private List<Object> lists;

    public Person() {
    }

    public Person(int age, String name, Date date, Map<String, Object> maps, List<Object> lists) {
        this.age = age;
        this.name = name;
        this.date = date;
        this.maps = maps;
        this.lists = lists;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }
}
