package com.github.krunalvora.concurrency;

public class ThreadExample {

    public static void main(String[] args) {
        
        Thread thread = new Thread();
        thread.start();

        
        // class implementing Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        
        // class implementing Runnable
        Thread myRunnableThread = new Thread(new MyRunnable(), "MyRunnableCustomName");
        myRunnableThread.start();


        // anonymous runnable class
        Runnable anonRunnable = new Runnable() {
            public void run() {
                System.out.println("\nAnonymous Runnable running...");
                System.out.println("Anonymous Runnable finished.");
            }
        };
        Thread anonRunnableThread = new Thread(anonRunnable);
        anonRunnableThread.start();

        
        // lambda runnable
        Runnable lambdaRunnable = () -> {
            System.out.println("\nLambda Runnable running...");
            System.out.println("Lambda Runnable finished.");
        };
        Thread lambdaRunnableThread = new Thread(lambdaRunnable);
        lambdaRunnableThread.start();


    }

    public static class MyThread extends Thread {

        public void run() {
            System.out.println("\nMyThread running...");
            System.out.println("MyThread finished.");
        }

    }

    public static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("\nMyRunnable running...");

            Thread currentThread = Thread.currentThread();
            System.out.println("MyRunnable thread name: " + currentThread.getName());

            System.out.println("MyRunnable finished.");
        }
    }

}