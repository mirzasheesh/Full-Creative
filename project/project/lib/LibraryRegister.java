package project.lib;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

//import java.text.*;
import project.lib.*;

public abstract class LibraryRegister
{
    protected static HashMap<Integer, Entry> entries = new HashMap<Integer, Entry>();

    public static int issueBook(int enrollmentNumber, int bookID, LocalDate date)
    {
        int bookCopy = Book.pullBook(bookID);

        if (bookCopy == -1)
        {
            System.out.println("Book is not available in the library");
            return -1;
        }
        else
        {
            System.out.println("BookCopyID: " + bookCopy + " is issued from the library");
            Student.issueBook(enrollmentNumber, bookCopy);
            LibraryRegister.entries.put(bookCopy, new Entry(enrollmentNumber, date, bookCopy));
        }
        LibraryRegister.save();
        return bookCopy;
    }

    public static int issueBook(int enrollmentNumber, int bookID)
    {
        return issueBook(enrollmentNumber, bookID, LocalDate.now());
    }

    public static void returnBook(int enrollmentNumber, int bookCopyID, LocalDate date)
    {
        Entry checkEntry = LibraryRegister.entries.get(bookCopyID);

        if(checkEntry == null)
        {
            System.out.println("BookCopyID: " + bookCopyID + ", is not issued from the library, or the entry doesn't exist");
            return;
        }

        if(checkEntry.returned)
        {
            System.out.println("BookCopyID: " + bookCopyID + ", is already returned to the library");
            return;
        }
        if(checkEntry.issueDate.plusDays(14).compareTo(date) < 0)
        {
            Student.addDue(checkEntry.enrollmentNumber, 5);
            System.out.println("Fine of rs. 5/- is applied for returning late");
        }
        System.out.println("BookCopyID: " + bookCopyID + " is returned to the library");
        checkEntry.returned = true;
        checkEntry.returnDate = date;
        Student.returnBook(enrollmentNumber, bookCopyID);
        LibraryRegister.save();
    }

    public static void returnBook(int enrollmentNumber, int bookCopyID)
    {
        returnBook(enrollmentNumber, bookCopyID, LocalDate.now());
    }

    public static void listEntries()
    {
        Iterator <Integer> iterate = entries.keySet().iterator();
        while(iterate.hasNext())
        {
            Entry newE = entries.get((int) iterate.next());
            System.out.println("Entry: " + newE.bookCopyID + ", issued on Date: " + newE.issueDate + ", by StudentID: " + newE.enrollmentNumber + ", Type: " + (newE.returned ? "Book Return, on Date: " + newE.returnDate : "Book Issue"));
        }
    }

    protected static void save()
    {
        try(ObjectOutputStream entriesOut = new ObjectOutputStream(new FileOutputStream("libraryEntries")))
        {
            entriesOut.writeObject(LibraryRegister.entries);
            entriesOut.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }

    static
    {
        try(ObjectInputStream entries = new ObjectInputStream(new FileInputStream("libraryEntries")))
        {
            @SuppressWarnings("unchecked")
            HashMap<Integer, Entry> loadedEntries = (HashMap<Integer, Entry>) entries.readObject();
            LibraryRegister.entries.putAll(loadedEntries);
            entries.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }
}

class Entry implements Serializable
{
    protected LocalDate issueDate;
    protected LocalDate returnDate;
    protected int enrollmentNumber;
    protected int bookCopyID;
    protected boolean returned;
    
    Entry(int enrollmentNumber, LocalDate date, int bookCopyID)
    {
        this.issueDate = date;
        this.enrollmentNumber = enrollmentNumber;
        this.bookCopyID = bookCopyID;
        this.returned = false;
    }
}