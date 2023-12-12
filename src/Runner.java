import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        CustomArrayList<Integer> list = new CustomArrayList<>(8);

        // Test add();

        list.add(25);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(4);

        System.out.println("Initial list with size: " + list.size() + ", capacity: 8.");
        System.out.println(list);
        System.out.println();

        List<Integer> list1 = new ArrayList<>();
        list1.add(77);
        list1.add(77);
        list1.add(77);

        //Test addAll();

        list.addAll(list1);
        //Test bubble sort

        System.out.println("List with added 3 elements with value 77 by addAll();");
        System.out.println(list);
        System.out.println();

        CustomArrayList.sort(list, Comparator.naturalOrder());

        System.out.println("Sorted list by static sort();");
        System.out.println(list);
        System.out.println();

        //Test get();

        System.out.println("Test get(); in for loop");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //Test set();

        System.out.println("Update value of element with index 5. method set();");

        list.set(5, 10);

        System.out.println(list);
        System.out.println();

        //Test remove();

        System.out.println("Remove element from list with value 2");

        list.remove(2);

        System.out.println(list);
        System.out.println();

        //Test constructor with Collection in parameter

        System.out.println("Test constructor with Collection parameter");
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);

        System.out.println(collection);

        CustomArrayList<Integer> list2 = new CustomArrayList<>(collection);

        System.out.println(list2);
    }
}