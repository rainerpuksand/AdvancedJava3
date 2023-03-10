package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Stream4 {
    public static void main(String[] args) {

        Phone obj1 = new Phone("Xiaomi",28000);
        Phone obj2 = new Phone("OnePlus7",13000);
        Phone obj3 = new Phone("Pixel",35000);
        Phone obj4 = new Phone("Sony",80000);
        Phone obj5 = new Phone("iPhone", 100000);

        List<Phone> phoneList = new ArrayList<Phone>();

        //Add the phone Objects
        phoneList.add(obj1);
        phoneList.add(obj2);
        phoneList.add(obj3);
        phoneList.add(obj4);
        phoneList.add(obj5);

        int sumOfPrices =
                phoneList.stream()
                .map(p -> p.price)
                .reduce(0,(sum, price) -> sum + price);

        System.out.println("Total Price of all phones: " + sumOfPrices);

        sumOfPrices =
                phoneList.stream()
                        .filter(p -> p.price>35000)
                        .map(p -> p.price)
                        .reduce(0,(sum, price) -> sum + price);

        System.out.println("Total Price of all phones: " + sumOfPrices);

        long count = phoneList.stream()
                .filter(p -> p.price<36000)//remove filter to get
                .count();
        System.out.println("Phones less than 35k: " + count);


        List<Integer> numsList = new ArrayList<>();
        numsList.add(2);
        numsList.add(3);
        numsList.add(4);
        numsList.add(5);
        numsList.add(6);
        IntSummaryStatistics summary =
                numsList.stream()
                .mapToInt(x -> x)//cant be just any stream so needs to be converted... but dont need this at 22222
                .summaryStatistics();
        System.out.println("ArrayList: ");
        System.out.println(summary);


        int[] numsArr= {2, 4, 6, 8, 10};
        IntSummaryStatistics summary1 =
                IntStream.of(numsArr)
                .summaryStatistics();//22222... dint need mapToInt...as it was already started by an IntStream
        System.out.println("Arrays: ");
        System.out.println(summary1);
        //summary1.getAverage();//getCount()...etc etc

        //Interview question how does a stream flow
        int[] numsArr1= {2, 4, 6, 8, 10, 20, 30 , 40, 50,5,60};
        IntStream.of(numsArr1).filter(value -> {System.out.println(value + "-1");return value>10; })
                .map(operand -> {System.out.println(operand + "-22");return operand*2;})
                .forEach(value -> System.out.println(value+ "-333"));

    }
}
