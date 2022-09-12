package internship;

public class StrBuffer {
    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("First Word"); //str => First Word
        System.out.println(str);

        str.append(" Next Word"); //str => First Word + Next Word
        System.out.println(str);

        StringBuffer str2 = new StringBuffer("First Word Next Word");

        System.out.println(str.equals(str2)); //StringBuffer does not override equals method, will compare reference not string content

        str.insert(0, new StringBuffer("at index 0 "));
        System.out.println(str);
    }
}