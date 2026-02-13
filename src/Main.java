package src;

public class Main extends Thread {
    static int total=0;
    public  void run(){
        synchronized (this){
        for (int i = 1; i < 100; i++) {
            try {
                sleep(10l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            total=total+i;
        }
        this.notify();
        }


    }
    public static void main(String[] args) throws InterruptedException {
        Main main=new Main();
        main.start();
        //main.join();
     //   sleep(1l);
        synchronized (main){
            System.out.println("Enter In waiting State");
            main.wait();

        }

        System.out.println(total);
    }
}
