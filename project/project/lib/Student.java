package project.lib;

import java.util.*;
import java.io.*;
import project.lib.*;

public class Student implements Serializable
{
    private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
    private static int uniqueID = 0;
    
    private int enrollmentNumber;
    private String name;
    private String course;
    private String department;
    
    private LinkedList<Integer> issuedBooks = new LinkedList<>();

    private int feeDue;

    Student(String name, String course, String department)
    {
        uniqueID = uniqueID + 1;
        this.enrollmentNumber = uniqueID;
        this.name = name;
        this.course = course;
        this.department = department;
        this.feeDue = 0;
        students.put(enrollmentNumber, this);
        Student.save();
        System.out.println("New student enrolled, Name: " + this.name + ", Enrollment: " + this.enrollmentNumber + ", Course: " + this.course + ", Department: " + this.department);
    }

    public static int add(String name, String course, String department)
    {
        return new Student(name, course, department).enrollmentNumber;
    }

    void addDue(int amount)
    {
        this.feeDue = this.feeDue + amount;
        Student.save();
    }

    protected static void addDue(int enrollmentNumber, int amount)
    {
        students.get(enrollmentNumber).addDue(amount);
    }

    int checkDue()
    {
        return this.feeDue;
    }

    public static int checkDue(int enrollmentNumber)
    {
        return students.get(enrollmentNumber).checkDue();
    }

    void issueBook(int copyID)
    {
        this.issuedBooks.add(copyID);
        Student.save();
        System.out.println("Book: " + Book.bookNameByCopyID(copyID) + ", is issued to Student: " + this.name + ", Enrollment: " + this.enrollmentNumber);
    }

    protected static void issueBook(int enrollment, int copyID)
    {
        students.get(enrollment).issueBook(copyID);
    }

    void returnBook(int copyID)
    {
        Book.pushBook(copyID);
        this.issuedBooks.remove((Integer) copyID);
        Student.save();
        System.out.println("Book: " + Book.bookNameByCopyID(copyID) + ", is returned by Student: " + this.name + ", Enrollment: " + this.enrollmentNumber);
    }

    protected static void returnBook(int enrollment, int copyID)
    {
        students.get(enrollment).returnBook(copyID);
    }

    void pendingBooks()
    {
        System.out.print(this.name + "'s pending books to return: ");
        
        if (this.issuedBooks.size() == 0)
        {
            System.out.println("no books are available to return");
        }
        else
        {
            for (int bookCopy : this.issuedBooks)
            {
                System.out.print("\nBookCopyID: " + bookCopy + ", Title: " + Book.bookNameByCopyID(bookCopy));
            }
            System.out.println();
        }
    }

    public static void pendingBooks(int enrollmentNumber)
    {
        students.get(enrollmentNumber).pendingBooks();
    }

    public static void list()
    {
        Iterator iterateStudents = students.keySet().iterator();
        
        while (iterateStudents.hasNext())
        {
            Student newsStudent = students.get((int) iterateStudents.next());
            System.out.println("Student Name: " + newsStudent.name + ", Enrollment Number: " + newsStudent.enrollmentNumber + ", Course: " + newsStudent.course + ", Department: " + newsStudent.department + ", Fee Dues: " + newsStudent.feeDue);
        }
    }

    private static void save()
    {
        try(ObjectOutputStream studentsOut = new ObjectOutputStream(new FileOutputStream("studentsData")))
        {
            studentsOut.writeObject(students);
            studentsOut.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }

    static
    {
        try(ObjectInputStream studentsIn = new ObjectInputStream(new FileInputStream("studentsData")))
        {
            @SuppressWarnings("unchecked")
            HashMap<Integer, Student> loadedStudents = (HashMap<Integer, Student>) studentsIn.readObject();
            Student.students.putAll(loadedStudents);
            Student.uniqueID = students.size();
            studentsIn.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }
}