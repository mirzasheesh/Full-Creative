package internship;

import java.util.HashMap;
import java.util.HashSet;

public class MapandSet {
    public static void main(String[] args) {
        HashSet<Integer> students = new HashSet<>();
        HashMap<Integer, Student> information = new HashMap<>();
        String[] studentNames = {"Mukesh", "Suresh", "Mahesh", "Ramesh", "Vishesh", "Avesh", "Naresh", "Lokesh"};
        for(int rollNo = 101; rollNo < 101 + studentNames.length; rollNo++){
            students.add(rollNo);
            information.put(rollNo, new Student(rollNo, studentNames[rollNo - 101], rollNo - 100, 'A', (int) (Math.random() * 100)));
        }
        System.out.println("Roll numbers of students: " + students);
        students.forEach((student) -> {
            (information.get(student)).knowStudent();
        });
    }
}

class Student{
    int enrollNo;
    String name;
    int standard;
    char section;
    int marks;
    Student(int r, String n, int s, char se, int m){
        this.enrollNo = r;
        this.name = n;
        this.standard = s;
        this.section = se;
        this.marks = m;
    }
    void knowStudent(){
        System.out.println(this.name + " have roll number: " + enrollNo + ", student of class: " + standard + ", section: " + section + ", secured: " + marks + " marks out of 100");
    }
}