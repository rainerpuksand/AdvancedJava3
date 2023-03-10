package Threads;

public class RunnableInterface {
    public static void main(String[] args) {

        MyRunnableThread t = new MyRunnableThread();
        //t.start();//why this cant be called
        //t.getName();//similarly this cant be called
        //t.run(); //pointless... bcz only a ThreadClass will create a thread outside this main()
        //Thread tt = new Thread(t);//aggregation
        //tt.start();//this works


        //another way ===========================================
        Thread t0 = new Thread(new MyRunnableThread());//composition
        t0.start();
        Thread t1 = new Thread(new MyRunnableThread());
        t1.start();

        System.out.println("MainThread xxxxxxxxxxxxxxxxxxxxxxxx ");
        System.out.println("END!... Name: "+ Thread.currentThread().getName()+"|id: " + Thread.currentThread().getId());


    }
}

class MyRunnableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println(i+"- name: " + getName()+"| id: " + getId());//why this error
            System.out.println(i);
        }
    }
}
