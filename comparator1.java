package internship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class comparator1 {
    public static void main(String[] args) {
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car("Alto", 2009));
        list.add(new Car("WagonR", 2012));
        list.add(new Car("City", 2008));
        list.add(new Car("Verna", 2022));
        list.add(new Car("XUV", 2015));
        list.add(new Car("Swift", 2000));
        System.out.println("=> Unsorted List of cars");
        for( Car cr : list){
            System.out.println(cr.model + " " + cr.year);
        }
        Collections.sort(list, new YearCompare());
        System.out.println("=> Sorted List according year");
        for( Car cr : list){
            System.out.println(cr.model + " " + cr.year);
        }
        Collections.sort(list, new ModelCompare());
        System.out.println("=> Sorted List according model name a to z");
        for( Car cr : list){
            System.out.println(cr.model + " " + cr.year);
        }
    }   
}

class Car{
    String model;
    int year;
    Car(String model, int year){
        this.model = model;
        this.year = year;
    }
}

class ModelCompare implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2) {
        return (c1.model).compareTo(c2.model);
    }
}

class YearCompare implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2) {
        if(c1.year < c2.year) return -1;
        if(c2.year > c2.year) return 1;
        return 0;
    }
}