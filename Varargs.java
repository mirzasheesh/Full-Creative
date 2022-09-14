package internship;

import java.util.Arrays;

public class Varargs{
    public static void main(String[] args) {
        System.out.println("Hello Args");
        printArgs1(1, 2, 3);
        printArgs2("line1", "line2", "line3");
        String[] arr = {"element1", "element2", "element3"};
        printArgs3(arr);
        sum(1);
        sum(1,2);
        sum(1,2,3);
        sum(1,2,3,4);
        sum(1,2,3,4,5);
    }
    private static void printArgs1(int... args){
        System.out.println(Arrays.toString(args));
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        for(int num : args){
            System.out.println(num);
        }
    }
    private static void printArgs2(String... args){
        System.out.println(Arrays.toString(args));
        System.out.println(args.length);
        for(String line : args){
            System.out.println(line);
        }
    }
    private static void printArgs3(String[] array){
        System.out.println(Arrays.toString(array));
        for(String element : array){
            System.out.println(element);
        }
    }
    private static void sum(int...nums){
        int n = 0;
        for(int num : nums){
            n = n + num;
        }
        System.out.println(n);
    }
}