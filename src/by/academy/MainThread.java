package by.academy;

import javax.naming.TimeLimitExceededException;

public class MainThread {
    static long a = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        a ++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(" Number a =  " + a);
                    }
                });


        t1.start();
        System.err.println("Thread run :" + t1.isAlive());

        int count = 0;

        while (t1.isAlive() && count <= 5)
            try {

                System.out.println(" Join stop! ");

                t1.join(2000);
                count++;

            } catch (InterruptedException e) {
                t1.interrupt();
                System.err.println("Waiting to stop");

            }

        System.err.println("Thread stop.");
    }
}





