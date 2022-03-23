package com.company;

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                " family='" + family + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        if (this.getFamily().equals(p.getFamily()) && this.getAge() == p.getAge() && this.getSex().equals(p.getSex()))
        {   return true;}
        else {return false;}
    }
}
