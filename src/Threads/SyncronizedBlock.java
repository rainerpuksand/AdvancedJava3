package Threads;

public class SyncronizedBlock {///syncMethod
    static  int counter=0;

    //synchronized
    static public  void Increasecounter(){//sync
        counter++;
    }

    static public void PrintCounter(){
        System.out.println("Counter is: " + counter);
    }

    //================================================program starts
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Increasecounter();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    Increasecounter();
                }
            }
        });





        //t1.start();
        //t2.start();


       /* try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }*/


        PrintCounter();
    }
}

// volatile v/s atomic
// volatile boolean x; v/s AtomicInteger x;
// set flags v/s readwrite
// booleans v/s counters
// visibility v/s compound operations
