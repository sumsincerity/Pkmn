package ru.mirea.PchelintsevNI.pkmn;

public class Student {
    private String firstName;
    private String surName;
    private String familyName;
    private String group;

    public Student(String firstName, String surName, String familyName, String group) {
        this.firstName = firstName;
        this.surName = surName;
        this.familyName = familyName;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}