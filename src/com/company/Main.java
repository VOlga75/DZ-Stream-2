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

      /*  System.out.println("Список призывников:");
        List<String> militari = persons.stream()
                .filter(p -> p.getSex() == Sex.М)
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27)
                .map(p -> p.getFamily() + " " + p.getAge())
                .collect(Collectors.toList());
        for (String m : militari) {
            System.out.println(m);
        }*/

        System.out.println("Трудоспособное население:");
        List<Person> workerM = persons.stream()
                .filter(p -> p.getEducation() == Education.ВЫСШЕЕ)
                .filter(p -> p.getSex() == Sex.М)
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 65)
                .collect(Collectors.toList());
        System.out.printf(" мужчин: %s", workerM.size());
        List<Person> workerF = persons.stream()
                .filter(p -> p.getEducation() == Education.ВЫСШЕЕ)
                .filter(p -> p.getSex() == Sex.Ж)
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 60)
                .collect(Collectors.toList());
        System.out.printf(" женщин: %s", workerM.size());

        workerM.addAll(workerF);
        System.out.printf(" всего: %s", workerM.size());


        List<String> worker = workerM.stream()
                .map(p -> p.getFamily() + " " + p.getName() + " " + p.getEducation() + " " + p.getSex() + " " + p.getAge())
                //.distinct()
                .sorted(Comparator.naturalOrder())
                //.forEach(System.out::print); почему ошибка, если раскомментить эту строчку...я же делаю map  в стринг...
                .collect(Collectors.toList());


        for (String w : worker) {
            System.out.println(w);
        }

    }
}
