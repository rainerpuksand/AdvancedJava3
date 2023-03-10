package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceX {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);//refer note bottom

        Future<String> F_str = service.submit(new Task4String());
        Future<Integer> F_score =service.submit(new Task4Int());
        Future<Void> F_waiting = service.submit(new Task4waiting());

        System.out.println("Continuing....");

        //keep doing what you want
        //...................
        //...................
        //...................
        //...................
        System.out.println("... Still Continuing....");

        //Check if the futures are ready with answers
        System.out.println(F_str.isDone() + "|" + F_score.isDone() + "|" +F_waiting.isDone());


        //when you require the values back from the Callable threads....
        System.out.println("Now give me the answers.....");
        try {
            String str =  F_str.get();
            System.out.println("1.String=> " + str);
            Integer score = F_score.get();
            System.out.println("2.Integer=> " + score);
            F_waiting.get();//bottom note
            System.out.println("3." + str + score);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("xxxxxxxxxxxxxxxxxxxxx");
        service.shutdown();
    }
}


class Task4String implements Callable<String>{
String str=null;

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        str="My Score is: ";
        return str;
    }
}

class Task4Int implements Callable<Integer>{
int score=0;
    @Override
    public Integer call() throws Exception {
        Thread.sleep(6000);
        score = 100;
        return score;
    }
}

class Task4waiting implements Callable<Void>{
    @Override
    public Void call() throws Exception {
        Thread.sleep(10000);
        return null;
    }
}
//Notice the 1st & 2nd callable's future will be returned at 3 & 6 secs
// but the 3rd callables future will take more than 10s
// this is because it is spooling another thread since the prescribed number
// in the thread pool = 2. if you make that =3... it will return at
// exactly 10s

//if you place the 3rd callable's future .get() before all the others in the
// try block you will notice that nothing happens for 10s until F_waiting.get()
// has been finished. but in the mean time that we were waiting the other
// two callables have already finished... And so, the .get() on the other two
//  callables returns us the value immediately!
//
//
//            F_waiting.get();//if on top
//            String str =  F_str.get();
//            System.out.println("1.String=> " + str);
//            Integer score = F_score.get();
//            System.out.println("2.Integer=> " + score);
//
//            System.out.println("3." + str + score);