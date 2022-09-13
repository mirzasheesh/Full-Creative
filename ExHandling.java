package internship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExHandling{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scan = new Scanner(System.in);
        int n;
        //input mismatch exception
        try{
            System.out.print("Input: ");
            n = scan.nextInt();
            System.out.println("Result: " + n);
            scan.close();
        }catch(InputMismatchException e){
            System.out.println("Error: Input must be Integer");
        }
        //index out of bound exception
        int[] array = {1, 2, 3};
        System.out.print("Array: ");
        for(int i = 0; i < 4; i++){
            try{
                System.out.print(array[i] + " ");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error: Index: " + i + " not available");
            }
        }
    }
}