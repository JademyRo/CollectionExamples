package ro.jademy.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ListTester {


    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        resetList(stringList);

        // checking if an element exists in the list
        boolean containsElement = stringList.contains("Jane Doe");
        System.out.println("List contains element: " + containsElement + "\n");

        // checking the index of an element
        int elementIndex = stringList.indexOf("Jane Doe");
        System.out.println("Element index: " + elementIndex + "\n");

        int nonExistingElementIndex = stringList.indexOf("Other Name");
        System.out.println("Non-existing element index: " + nonExistingElementIndex + "\n");

        // getting an element by its index
        String element = stringList.get(1);
        System.out.println("List element: " + element + "\n");

        // removing an element by its index
        String removedElement = stringList.remove(1);
        System.out.println("Removed element: " + removedElement + "\n");

        resetList(stringList);

        // using the listIterator to iterate over elements forwards
        ListIterator<String> listIterator = stringList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Element in iteration: " + listIterator.next());
        }
        System.out.println();

        // using the listIterator to iterate over elements backwards
        ListIterator<String> backwardsListIterator = stringList.listIterator(stringList.size());
        while (backwardsListIterator.hasPrevious()) {
            System.out.println("Element in backwards iteration: " + backwardsListIterator.previous());
        }
        System.out.println();


        // calling the sort method on a list with comparable elements
        Collections.sort(stringList);
        printList("List after sort", stringList);
        resetList(stringList);


        // calling the shuffle method on a list with comparable elements
        Collections.shuffle(stringList);
        printList("List after shuffle", stringList);
        resetList(stringList);


        // calling the shuffle method on a list with comparable elements
        Collections.reverse(stringList);
        printList("List after reverse", stringList);
        resetList(stringList);


        // calling the shuffle method on a list with comparable elements
        Collections.swap(stringList, 1, 2);
        printList("List after swap", stringList);
        resetList(stringList);


        // calling the shuffle method on a list with comparable elements
        Collections.rotate(stringList, 5);
        printList("List after rotate", stringList);
        resetList(stringList);

    }

    private static void resetList(List<String> list) {
        list.clear();

        list.add("John Doe");
        list.add("Jane Doe");
        list.add("Joe Bloggs");
    }

    private static void printList(String message, List<String> list) {
        System.out.println(message);
        for (String s : list) {
            System.out.println("Element: " + s);
        }
        System.out.println();
    }
}
