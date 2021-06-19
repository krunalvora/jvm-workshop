package com.github.krunalvora.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    // Threads
    // Thread myThread = new Thread(TasksDemo.myRunnableTask);
    // myThread.start();

    // ExecutorService using Runnable
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(() -> {
      System.out.println(String.format("Running LambdaRunnableTask in thread: %s ...",
            Thread.currentThread().getName()));
    });

    // ExecutorService using Callable
    Future<String> future = executorService.submit(() -> String.format("Running LambdaCallableTask in thread: %s ...",
          Thread.currentThread().getName()));
    System.out.println(future.get());

    executorService.shutdown();

  }
}
