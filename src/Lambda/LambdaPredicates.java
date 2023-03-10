package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//to override TEST
//default methods  and, or and negate
public class LambdaPredicates {
    public static void main(String[] args) {

        Predicate<String> predicateString = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("my string");
            }
        };
        System.out.println(predicateString.test("my string"));

        /*Predicate<String> predicateString5= (s)-> s.equals("my string");
        System.out.println(predicateString5.test("my string"));*/


        predicateString= predicateString.and(s->s.length()<4);
        System.out.println(predicateString.test("my string") );
        System.out.println("==============================");



        Predicate<String> predicate1 = s -> s.equals("OMG");
        System.out.println(predicate1.test("OMG"));
        predicate1= predicate1.or(s->s.length()==3);
        System.out.println(predicate1.test("XXX") );
        System.out.println("==============================1");

        Predicate<String> predicate2 = s -> s.contains("G!");
        System.out.println(predicate2.test("OMG!"));
        System.out.println(predicate2.negate().test("OMG!"));
        System.out.println("==============================2");


        Predicate<String> predicate3 = s->s.startsWith("ab");
        System.out.println(predicate3.test("abba"));
        predicate3 = predicate3.and(s->s.endsWith("ba") );
        System.out.println(predicate3.test("abba"));

        //=================================================
        //ONLY AFTER STREAMS
        //=================================================
        System.out.println("FINAL==================");

        List<String> names = new ArrayList<>();
        names.add("abhi ba");
        names.add("asto pab");
        names.add("abidasba");
        names.add("abisaababa");
        names.add("abass");
        names.add("supab");
        List<String> myShortCut =
                names.stream()
                        .filter(predicate3)
                        .collect(Collectors.toList());

        System.out.println(myShortCut);





    }
}

