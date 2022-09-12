package internship;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello String"); //str => First Word
        System.out.println(str);
        str.append(" New Word"); // str => First Word + Next Word
        System.out.println(str);

        String str2 = new String("Hello String");
        System.out.println(str2);

        str2.concat(" New Word"); // str2 remains same
        System.out.println(str2);

        str2 = str2.concat(" New Word"); // str2 = new String(str2  + "New Word");
        System.out.println(str2);

        System.out.println("Hello" == "Hello"); // comparing literals

        StringBuilder str3 = new StringBuilder("Hello String New Word");

        System.out.println(str);
        System.out.println(str3);

        String str11 = new String("Hello");
        String str12 = new String("Hello");
        System.out.println(str11.equals(str12)); //String class have impl. of equal it can compare content/data information of string

        System.out.println(str.equals(str3)); //StringBuilder class doesn't have the implementation of equals() method like one in the String class

        System.out.println(str.toString().equals(str3.toString())); //we can check them by converting them to string
    }   
}