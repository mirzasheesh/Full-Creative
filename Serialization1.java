package internship;

import java.io.*;
import java.util.ArrayList;

public class Serialization1 {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(new Number(0, "zero"));
        list.add(new Number(1, "one"));
        list.add(new Number(2, "two"));
        list.add(new Number(3, "three"));
        list.add(new Number(4, "four"));
        list.add(new Number(5, "five"));
        System.out.println("++ => Writing data into file...");
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("obsData"))) {
            for (Number num : list) {
                System.out.print("Writing: ");
                num.read();
                objOut.writeObject(num);
            }
            objOut.flush();
            objOut.close();
        } catch (Exception e) {
            System.out.println("Error in writing file!");
        }
        System.out.println("++ => Reading file...");
        try (ObjectInputStream objOut = new ObjectInputStream(new FileInputStream("obsData"))) {
            for (int n = 0; n < 6; n++) {
                System.out.print("Reading: ");
                ((Number) objOut.readObject()).read();
            }
        } catch (Exception e) {
            System.out.println("Error in reading file!");
        }
    }
}

class Number implements Serializable {
    int data;
    String word;

    Number(int data, String word) {
        this.data = data;
        this.word = word;
    }

    void read() {
        System.out.println(this.data + " => " + this.word);
    }
}