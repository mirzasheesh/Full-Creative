package internship;

import java.io.IOException;

public class ThrowAnd {
    public static void main(String[] args) {
        System.out.println("Hello");
        /* Test Case 1*/
        try {
            input(1, "http://Windows");
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
        /* Test Case 2*/
        System.out.println("\n");
        try {
            input(0, "http://Windows");
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
        /* Test Case 3*/
        System.out.println("\n");
        try {
            input(0, "C://Windows");
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    static void input(int n, String path) throws ArithmeticException, IOException{
        if(n < 0){
            throw new ArithmeticException("Number can't be negative");
        }
        if(n > 0){
            throw new ArithmeticException("Number can't be positive");
        }
        System.out.println("Yeah I can accept a zero");
        if(path.contains("http")){
            throw new IOException("Required local directory path, not url");
        }
        System.out.println("Hey, you are looking for " + path + " directory");
    }
}