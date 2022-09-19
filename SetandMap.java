package internship;

import java.util.HashMap;
import java.util.HashSet;

public class SetandMap{
    /*
        add(E e)            Used to add the specified element if it is not present, if it is present then return false.
        clear()             Used to remove all the elements from set.
        contains(Object o)	Used to return true if an element is present in set.
        remove(Object o)	Used to remove the element if it is present in set.
        isEmpty()	        Used to check whether the set is empty or not. Returns true for empty and false for a non-empty condition for set.
        size()	            Used to return the size of the set.
        clone()	            Used to create a shallow copy of the set.
    */
    /*
        containsKey(Object key)	    Returns true if this map contains a mapping for the specified key.
        containsValue(Object value)	Returns true if this map maps one or more keys to the specified value.
        get(Object key)	            Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        isEmpty()	                Returns true if this map contains no key-value mappings.
        put(K key, V value)	        Associates the specified value with the specified key in this map.
        remove(Object key)	        Removes the mapping for the specified key from this map if present.
        size()	                    Returns the number of key-value mappings in this map.
        values()	                Returns a Collection view of the values contained in this map.
    */
    public static void main(String[] args) {
        HashSet<Integer> alphabetsList = new HashSet<>();
        for(int s = 65; s <= 90; s++){
            alphabetsList.add(s);
        }
        HashMap<Integer,Character> alphabets = new HashMap<>();
        for(int alph : alphabetsList){
            alphabets.put(alph, (char) alph);
            System.out.print(alphabets.get(alph) + " ");
        }
        System.out.print("\n");
        System.out.print(alphabets);
        /*
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> dups = new HashMap<>();
        int [] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        System.out.print("Elements: ");
        for(int num : arr){
            if(!set.add(num)){
                dups.put(num, dups.get(num) + 1);
                System.out.print(num + "[D] ");
            }else{
                dups.put(num, 1);
                System.out.print(num + " ");
            }
        }
        System.out.print("\nSet: " + set);
        System.out.print("\nMap: " + dups);
        */
    }
}