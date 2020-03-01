package kathySierra;

public class OddEvenThreads implements Runnable{
    public static void main(String[] args) {
       OddEvenThreads oet = new OddEvenThreads();
       Thread odd = new Thread(oet);
       odd.setName("odd");
       Thread even = new Thread(oet);
       even.setName("even");
       odd.start();
       even.start();
       try{odd.join();}
       catch(Exception e){}
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (i % 2 == 0 && Thread.currentThread().getName() == "even") {
                    System.out.println(i + "printed by" + Thread.currentThread().getName());
                    notify();
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
                else{
                    try {wait();} catch (Exception e){}
                }
                if (i % 2 != 0 && Thread.currentThread().getName() == "odd") {
                    System.out.println(i + "printed by" + Thread.currentThread().getName());
                    notify();
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
                else{
                    try {wait();} catch (Exception e){}
                }
            }
        }
    }
}
