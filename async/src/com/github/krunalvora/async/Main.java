package com.github.krunalvora.async;

public class Main {

  public static void main(String[] args) {

    MyTask myTask = new MyTask();
    myTask.run();

    Runnable lambdaRunnableTask = () -> {
      System.out.println("Running lambdaRunnableTask ...");
    };
  }
}
