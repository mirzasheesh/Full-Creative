package internship;

import java.util.ArrayList;
import java.util.Collections;

public class comparable1 {
    public static void main(String[] args) {
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car(2009));
        list.add(new Car(2012));
        list.add(new Car(2002));
        list.add(new Car(2022));
        list.add(new Car(2015));
        list.add(new Car(2000));
        System.out.println("Unsorted List od models");
        for( Car cr : list){
            System.out.println(cr.model);
        }
        Collections.sort(list);
        System.out.println("Sorted List od models");
        for( Car cr : list){
            System.out.println(cr.model);
        }
    }   
}

class Car implements Comparable<Car>{
    int model;
    Car(int model){
        this.model = model;
    }
    @Override
    public int compareTo(Car cr) {
        if(this.model < cr.model) return -1;
        if(this.model > cr.model) return 1;
        return 0;
    }
}