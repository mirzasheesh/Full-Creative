package internship;

import java.util.*;

public class MapandSetandLinkedList {
    public static void main(String[] args) {
        HashSet<Integer> students = new HashSet<>();
        HashMap<Integer, Student> information = new HashMap<>();
        String[] studentNames = {"Mukesh", "Suresh", "Mahesh", "Ramesh", "Vishesh", "Avesh", "Naresh", "Lokesh"};
        for(int rollNo = 101; rollNo < 101 + studentNames.length; rollNo++){
            students.add(rollNo);
            information.put(rollNo, new Student(rollNo, studentNames[rollNo - 101], rollNo - 100, 'A', (int) (Math.random() * 100)));
        }
        System.out.println("Roll numbers of students: " + students);
        LinkedList<Student> list = new LinkedList<>();
        students.forEach((student) -> {
            list.add(information.get(student));
            //(information.get(student)).knowStudent();
        });
        Collections.sort(list);
        for(Student stu : list){
            stu.knowStudent();
        }
    }
}

class Student implements Comparable<Student>{
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
    @Override
    public int compareTo(Student o) {
        return o.marks - this.marks;
    }
}