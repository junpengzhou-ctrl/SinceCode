package com.itheima.bean;

public class Student {
    private int age;
    private int score;
    private String name;

    public Student() {
    }

    public Student(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
