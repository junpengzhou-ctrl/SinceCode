package com.nanjin.bean;

public class Student {
    private String username;
    private int age;
    private int score;
    private int id;

    public Student() {
    }

    public Student(String username, int age, int score, int id) {
        this.username = username;
        this.age = age;
        this.score = score;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
