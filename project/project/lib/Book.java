package project.lib;

import java.io.*;
import java.util.*;

public class Book implements Serializable
{
    private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();
    private static int uniqueID = 0;

    private String bookName;
    private int bookID;
    private int quanity;

    private LinkedList<Integer> bookCopies = new LinkedList<>();

    Book(String bookName)
    {
        uniqueID = uniqueID + 1;

        this.bookName = bookName;
        this.bookID = uniqueID;
        this.quanity = 0;

        books.put(bookID, this);
        Book.save();
        System.out.println("New book added, Title: " + this.bookName + ", BookID: " + this.bookID + ", Qty: " + this.quanity);
    }

    public static int add(String bookName)
    {
        return new Book(bookName).bookID;
    }

    public static String bookNameByCopyID(int copyID)
    {
        return books.get((int) copyID / 1000).bookName;
    }

    void addStock(int qty)
    {
        this.quanity = this.quanity + qty;
        int length = bookCopies.size() + 1;
        for (int bID = bookID * 1000 + length; bID < (bookID * 1000) + qty + length; bID++)
        {
            bookCopies.add(bID);
        }
        Book.save();
        System.out.println("Stock updated, Title: " + this.bookName + ", BookID: " + this.bookID + ", Qty: " + this.quanity);
    }

    public static void addStock(int bookID, int qty)
    {
        books.get(bookID).addStock(qty);
    }

    int pullBook()
    {
        if (this.quanity < 1) return -1;
        this.quanity = this.quanity - 1;
        int bID = this.bookCopies.removeFirst();
        Book.save();
        return bID;
    }

    protected static int pullBook(int bookID)
    {
        return books.get(bookID).pullBook();
    }

    protected static void pushBook(int bookCopyID)
    {
        Book thisBook = books.get((int) bookCopyID / 1000);
        thisBook.quanity = thisBook.quanity + 1;
        thisBook.bookCopies.add(bookCopyID);
        Book.save();
    }

    public static void list()
    {
        Iterator iterateBooks = books.keySet().iterator();

        while (iterateBooks.hasNext())
        {
            Book newBook = books.get((int) iterateBooks.next());
            System.out.println("Book Title: " + newBook.bookName + ", BookID: " + newBook.bookID + ", Quantities: " + newBook.quanity);
        }
    }

    private static void save()
    {
        try(ObjectOutputStream booksOut = new ObjectOutputStream(new FileOutputStream("booksData")))
        {
            booksOut.writeObject(books);
            booksOut.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }

    static
    {
        try(ObjectInputStream booksIn = new ObjectInputStream(new FileInputStream("booksData")))
        {
            @SuppressWarnings("unchecked")
            HashMap<Integer, Book> loadedBooks = (HashMap<Integer, Book>) booksIn.readObject();
            Book.books.putAll(loadedBooks);
            Book.uniqueID = books.size();
            booksIn.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
    }
}