package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambda1 {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(98);
        myList.add(154);
        myList.add(45);
        myList.add(14);
        myList.add(33);
        myList.add(62);

        for(int i = 0; i< myList.size(); i++){
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("\n================");

        myList.forEach(e -> System.out.print(e + " ") );
        System.out.println();
        myList.forEach(z -> System.out.print((z+1) + " ") );
        System.out.println();
        myList.forEach(e -> {e++;
                                e++;
                                    System.out.println(e);} );

    }

}
