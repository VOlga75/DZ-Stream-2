package com.company;

import java.util.Comparator;

class ComparePersonAge implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b){
        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
