package kr.co.ktpark.javaProgram.threads.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture
 * CompletableFuture With ExecutorService
 */

public class ThreadTest01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        basicCreateCompletableFuture();

        returnValueWithCompletableFuture();

        threadWithCallbackFunction();

        // CompletableFuture => ForkJoinPool => CommonPool (Default)
        useExecutorServiceWithCompletableFuture();

    }

    private static void useExecutorServiceWithCompletableFuture() throws InterruptedException, ExecutionException {

        // Use ExecutorService With CompletableFuture

        // 01.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> { // 두번째 인자에 executorService
            return "Hello Brother";
        }, executorService).thenAccept((string) -> {
            System.out.println("Callback Function : " + string);
            System.out.println(Thread.currentThread().getName());
        });

        completableFuture.get();

        executorService.shutdown();

        // 02.
        ExecutorService executorServiceAsync = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFutureAsync = CompletableFuture.supplyAsync(() -> { // 두번째 인자에 executorService
            return "Hello! Call Of Duty!";
        }, executorServiceAsync).thenAcceptAsync((string) -> {
            System.out.println("Callback Function : " + string);
            System.out.println(Thread.currentThread().getName());
        }, executorServiceAsync);

        completableFutureAsync.get();

        executorServiceAsync.shutdown();

    }

    private static void threadWithCallbackFunction() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "Park Kyung Taek";
        }).thenAccept((str) -> { // thenRun : 결과값 상관없이 수행하고 싶은 경우 (Runnable)
            // Return Void Callback Function
            System.out.println("Return Void is Using thenAccept Method.");
        });

        voidCompletableFuture.get();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "Java Virtual Machine" + " / " + Thread.currentThread().getName();
        }).thenApply((str) -> {
            // Return Type Callback Function
            System.out.println(Thread.currentThread().getName());
            return str.toUpperCase();
        });

        System.out.println(completableFuture.get());

    }

    private static void returnValueWithCompletableFuture() throws InterruptedException, ExecutionException {

        // 리턴 값이 없는 경우 (Runnable) : CompletableFuture.runAsync()
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello CompletableFuture => runAsync() : " + Thread.currentThread().getName());
        });

        voidCompletableFuture.get();

        // 리턴 타입이 있는 경우 (Callable) : COmpletableFutre.supplyAsync()
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "Java Virtual Machine" + " / " + Thread.currentThread().getName();
        });

        String futureResult = completableFuture.get();
        System.out.println(futureResult);

    }

    private static void basicCreateCompletableFuture() throws InterruptedException, ExecutionException {

        // Static Use (기본값 설정)
        CompletableFuture<String> completableFuture =CompletableFuture.completedFuture("Park Kyung Taek");

        // New Instance Use
        // CompletableFuture<String> completableFuture = new CompletableFuture<>();
        // completableFuture.complete("Park Kyung Taek"); // Future 작업의 기본 값

        System.out.println(completableFuture.get());

    }
}
