package Threads;

public class ThreadClass {
    public static void main(String[] args) {

        MySimpleThread st = new MySimpleThread();
        //st.run();
        //st.start();


       MyThreadClass t = new MyThreadClass();
       t.start();
       MyThreadClass t1 = new MyThreadClass();
       t1.start();

        System.out.println("MainThread xxxxxxxxxxxxxxxxxxxxxxxx ");
        System.out.println("END!... Name: "+ Thread.currentThread().getName()+"|id: " + Thread.currentThread().getId());

    }
}

class MySimpleThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " from Simple Thread");
        }
    }
}

class MyThreadClass extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "| id: " + getId());
            try {
                Thread.sleep(500);//showing mix up
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}