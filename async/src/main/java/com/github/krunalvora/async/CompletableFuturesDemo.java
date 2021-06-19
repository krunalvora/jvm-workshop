package com.github.krunalvora.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFuturesDemo {

  public static void main(String[] args) throws InterruptedException {

    // Runnables
    Runnable myRunnableTask = () -> {
      System.out.println(String.format("Running Lambda RunnableTask in thread: %s ...",
            Thread.currentThread().getName()));
    };

    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(myRunnableTask);



    // Suppliers
    Supplier<String> supplierTask = () -> String.format("Running Lambda SupplierTask in thread: %s ...",
          Thread.currentThread().getName());
    CompletableFuture<String> supplierTaskFuture = CompletableFuture.supplyAsync(supplierTask);


    Thread.sleep(6000);

  }
}
