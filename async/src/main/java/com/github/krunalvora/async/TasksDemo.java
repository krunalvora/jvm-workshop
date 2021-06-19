package com.github.krunalvora.async;

import java.util.concurrent.Callable;

public class TasksDemo {

  public static MyRunnableTask myRunnableTask = new MyRunnableTask();
  public static Runnable myInlineRunnableTask;
  public static Runnable myLambdaRunnableTask;
  public static Callable<String> myInlineCallableTask;
  public static Callable<String> myLambdaCallableTask;

  public static void main(String[] args) {

    // Runnables
    myRunnableTask.run();


    myInlineRunnableTask = new Runnable() {
      @Override
      public void run() {
        System.out.println(String.format("Running myInlineRunnableTask in thread: %s ...",
              Thread.currentThread().getName()));
      }
    };
    myInlineRunnableTask.run();


    myLambdaRunnableTask = () -> {
      System.out.println("Running myLambdaRunnableTask ...");
    };
    myLambdaRunnableTask.run();


    // Callables
    myInlineCallableTask = new Callable<String>() {
      @Override
      public String call() throws Exception {
        return "Running myInlineCallableTask ...";
      }
    };
    try {
      String output = myInlineCallableTask.call();
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }

    myLambdaCallableTask = () -> "Running myLambdaCallableTask ...";
    try {
      String output = myLambdaCallableTask.call();
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
