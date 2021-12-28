package com.company;


public class Eater implements Runnable {
    private int eaten = 0;
    private boolean successful = true;

    @Override
    public void run() {
        while (successful) {
            if (randomBool()) {
                successful = eat();
                ++eaten;
                System.out.println(Thread.currentThread().getName() + " съел: " + eaten);
            } else {
                successful = reflect();
            }
        }
        System.out.println(Thread.currentThread().getName() + "ушел");
    }

    public static synchronized boolean eat() {
        System.out.println(Thread.currentThread().getName() + " ест");
        boolean successful = sleep();
        System.out.println(Thread.currentThread().getName() + "перестал есть");
        return successful;
    }

    public static boolean reflect() {
        System.out.println(Thread.currentThread().getName() + " ожидает");
        boolean successful = sleep();
        System.out.println(Thread.currentThread().getName() + " перестал ожидать");
        return successful;
    }

    /**
     * Возвращает успешность сна:
     * - если поспал без прерываний -> true;
     * - иначе -> false.
     */
    public static boolean sleep() {
        try {
            Thread.sleep(randomSleep());
            return true;
        } catch (InterruptedException ignored) {}
        return false;
    }

    public static boolean randomBool() {
        return Math.random() < 0.5;
    }

    public static int randomSleep() {
        return (int)(Math.random() * 3000) + 500;
    }
}
