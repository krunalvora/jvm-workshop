package com.github.krunalvora.async;

import java.util.concurrent.Callable;

public class App {

  public static void main(String[] args) {

    // Runnables
    MyTask myTask = new MyTask();
    myTask.run();


    Runnable myRunnableTask = new Runnable() {
      @Override
      public void run() {
        System.out.println("Running myRunnableTask ...");
      }
    };
    myRunnableTask.run();


    Runnable myLambdaRunnableTask = () -> {
      System.out.println("Running myLambdaRunnableTask ...");
    };
    myLambdaRunnableTask.run();


    // Callables
    Callable<String> myCallableTask = new Callable<String>() {
      @Override
      public String call() throws Exception {
        return "Running myCallableTask ...";
      }
    };
    try {
      myCallableTask.call();
    } catch (Exception e) {
      e.printStackTrace();
    }

    Callable<String> myLambdaCallableTask = () -> "Running myLambdaCallableTask ...";
    try {
      myLambdaCallableTask.call();
    } catch (Exception e) {
      e.printStackTrace();
    }



  }
}
