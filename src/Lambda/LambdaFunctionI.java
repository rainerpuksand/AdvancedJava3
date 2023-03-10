package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//to override APPLY
//default methods  andThen(), compose()
public class LambdaFunctionI {
    public static void main(String[] args) {

        Function<String,Integer> funcInterface = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(funcInterface.apply("YohanWadia"));


        System.out.println("=============================");
        Function<Integer,String> funcInterface1 = (i) -> i + ", Mangoes";
        System.out.println(funcInterface1.apply(5));

        System.out.println("=============================");
        //if Block inside lambda
        Function<Integer,String> funcInterface2 = i->{
           if (i==1){ return i + ", Mango";}
           else{return i + ", Mangoes";}
        };
        System.out.println(funcInterface2.apply(1));

        System.out.println("=============================");
        //.andThen()
        Function<Integer, Integer> funcInferface3 = i -> i*i;
        funcInferface3 = funcInferface3.andThen(x -> x + 100);
        System.out.println(funcInferface3.apply(5));


        System.out.println("=============================");
        //.compose()
        Function<Integer, Integer> funcInferface4 = i -> i*i;
        funcInferface4 = funcInferface4.compose(x -> x + 100);
        System.out.println(funcInferface4.apply(-95));



        System.out.println("MIX Proof====================");
        //... all 3 methods
        Function<Integer, Integer> funcInferface5 = i -> i*i;
        funcInferface5 = funcInferface5.andThen(y-> y*2);
        funcInferface5 = funcInferface5.compose(x -> x + 100);

        System.out.println(funcInferface5.apply(-95));

        //=================================================
        //ONLY AFTER STREAMS
        //=================================================
        System.out.println("FINAL==================");
        List<Integer> numsList = new ArrayList<>();
        numsList.add(22);
        numsList.add(-88);
        numsList.add(3);
        numsList.add(-94);
        numsList.add(6);
        numsList.add(-91);
        List<Integer> myShortCut =
                numsList.stream()
                        .filter(p -> p < 0)
                        .map(funcInferface5)
                        .collect(Collectors.toList());

        System.out.println(myShortCut);
    }
}
