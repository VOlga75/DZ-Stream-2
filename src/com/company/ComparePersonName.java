package com.company;

import java.util.Comparator;

class ComparePersonName implements Comparator<Person>{

    public int compare(Person a, Person b){

        return a.getFamily().compareTo(b.getFamily());
    }
}
