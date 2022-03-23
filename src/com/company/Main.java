package com.company;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

       long do18 = persons.stream()
                .filter(val -> val.getAge() <= 18)
                .count();
        System.out.printf("\n В переписи населения участвовало %d несовершеннолетних", do18);

       System.out.println("Список призывников:");
        List<String> militari = persons.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27)
                .map(p -> p.getFamily() + " " + p.getAge())
                .collect(Collectors.toList());
        for (String m : militari) {
            System.out.println(m);
        }


        System.out.println("\nТрудоспособное население:");
        Comparator<Person> comp = new ComparePersonName().thenComparing(new ComparePersonAge());
        //List<Person> workerM = persons.stream()
        persons.stream()
                .filter(p -> p.getEducation() == Education.HIGHER)
                .distinct() // ей-то что надо?) метод equals в классе Person есть, работает...Ничего не понилаю...
                .filter(p -> p.getAge() >= 18  && ((p.getSex() == Sex.WOMAN && p.getAge() <= 60 ) || (p.getSex() == Sex.MAN && p.getAge() <= 65 )))
                .sorted(comp)
                .forEach(System.out::println);

    }
}
