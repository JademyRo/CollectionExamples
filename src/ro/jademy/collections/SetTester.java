package ro.jademy.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTester {

    public static void main(String[] args) {

        // the Set interface contains only methods inherited from Collection
        // the Set interface has three implementations: HashSet, TreeSet and LinkedHashSet
        // usually, the HashSet is the fastest

        Set<Integer> intHashSet = new HashSet<>();
        Set<Integer> intTreeSet = new TreeSet<>();
        Set<Integer> intLinkedHashSet = new LinkedHashSet<>();

        long startHash = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intHashSet.add(i);
        }
        long endHash = System.currentTimeMillis();

        long startTree = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intTreeSet.add(i);
        }
        long endTree = System.currentTimeMillis();

        long startLinked = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedHashSet.add(i);
        }
        long endLinked = System.currentTimeMillis();

        System.out.println("HashSet duration: " + (endHash - startHash));
        System.out.println("TeeSet duration: " + (endTree - startTree));
        System.out.println("LinkedHashSet duration: " + (endLinked - startLinked));
        System.out.println();


        // the Set interface adds a stronger contract on the behavior of equals and hashcode so that different
        // set implementations are equal if they have the same elements
        System.out.println("Is the HashSet equal to the TreeSet: " + intHashSet.equals(intTreeSet));
        System.out.println("Is the HashSet equal to the LinkedHashSet: " + intHashSet.equals(intLinkedHashSet));
        System.out.println("Is the TreeSet equal to the LinkedHashSet: " + intTreeSet.equals(intLinkedHashSet));
    }
}
