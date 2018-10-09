package ro.jademy.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTester {

    public static void main(String[] args) {


        // a collection variable can be used with any concrete collection implementation
        Collection<String> collection = new ArrayList<>();

        System.out.println("The collection is empty: " + collection.isEmpty());
        System.out.println("The size of the empty collection is " + collection.size());
        System.out.println();


        // we can specify what types of elements the collection will hold by using generics
        Collection<Employee> employeeCollection = new ArrayList<>();


        // we can use add or addAll to add a single item or a collection of items to our collection
        Employee empl1 = new Employee(1, "John", "Doe");
        employeeCollection.add(empl1);

        Employee empl2 = new Employee(2, "Jane", "Doe");
        Employee empl3 = new Employee(3, "Joe", "Bloggs");
        employeeCollection.addAll(Arrays.asList(empl2, empl3));


        // we can iterate over the collection by using a for-each construct
        for (Employee employee : employeeCollection) {
            System.out.println("Employee in for-each: " + employee);
        }
        System.out.println();


        // or by using an iterator object
        Iterator<Employee> emplIterator1 = employeeCollection.iterator();
        while (emplIterator1.hasNext()) {
            System.out.println("Employee in iteration: " + emplIterator1.next());
        }
        System.out.println();


        // we can also transform our collection to an object array
        Object[] objectArray = employeeCollection.toArray();
        for (Object obj : objectArray) {
            System.out.println("Employee as object in an array: " + obj);
        }
        System.out.println();

        // or an Employee array, by using generics
        Employee[] employeeArray = employeeCollection.toArray(new Employee[employeeCollection.size()]);
        for (Employee empl : employeeArray) {
            System.out.println("Employee as Employee object in an array: " + empl);
        }
        System.out.println();


        // by using the iterator object we can also remove elements during the iteration
        // if we want to re-iterate, we need a new instance of the iterator object
        Iterator<Employee> emplIterator2 = employeeCollection.iterator();
        while (emplIterator2.hasNext()) {
            Employee empl = emplIterator2.next();
            if (empl.getEmployeeId() == 1) {
                System.out.println("Removing employee: " + empl);
                emplIterator2.remove();
            }
        }
        System.out.println();

        for (Employee employee : employeeCollection) {
            System.out.println("Employee after remove: " + employee);
        }
        System.out.println();


        // adding the first element again for testing purposes
        employeeCollection.add(empl1);


        // we can check if a collection contains an element
        // the contains method checks for equality using the equals() method so be sure to override equals and hashCode!
        boolean firstEmplContains = employeeCollection.contains(empl1);
        System.out.println("First employee is in collection: " + firstEmplContains);
        System.out.println();


        // we can also check if a collection contains a subset of elements
        Collection<Employee> subset = Arrays.asList(empl1, empl2);
        boolean subsetEmplContains = employeeCollection.containsAll(subset);
        System.out.println("First and second employees are in collection: " + subsetEmplContains);
        System.out.println();


        // retain all retains only the elements in the collection that are also present in the given collection
        // the method tests for equality by calling the equals() method so be sure to override equals and hashCode!
        employeeCollection.retainAll(subset);

        for (Employee employee : employeeCollection) {
            System.out.println("Employee after retain: " + employee);
        }
        System.out.println();


        // adding the first element again for testing purposes
        employeeCollection.add(empl3);


        // remove all removes all elements in the first collection that are also in the given collection
        // the method tests for equality by calling the equals() method so be sure to override equals and hashCode!
        employeeCollection.removeAll(subset);

        for (Employee employee : employeeCollection) {
            System.out.println("Employee after remove: " + employee);
        }
        System.out.println();


        // clear empties the collection
        employeeCollection.clear();
        System.out.println("Collection size after clear: " + employeeCollection.size());


    }
}
