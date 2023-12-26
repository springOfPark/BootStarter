package kr.co.ktpark.javaProgram.threads.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Thread 01 결과를 받고, Thread 02 처리를 하고 싶은 경우 => thenCompose 사용
 */

public class ThreadTest02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {

            String currentThreadName = Thread.currentThread().getName();
            String returnValue = "HELLO!";

            System.out.println(returnValue + " / " + currentThreadName);

            return returnValue;

        });

        // hello 작업 이후 추가적인 작업 진행 지시
        CompletableFuture<String> completableFuture = helloFuture.thenCompose(ThreadTest02::doThreadProcess);

        // hello 작업 받아서, world 작업 진행
        System.out.println(completableFuture.get());

    }

    private static CompletableFuture<String> doThreadProcess(String message) {

        return CompletableFuture.supplyAsync(() -> {

            String currentThreadName = Thread.currentThread().getName();
            String returnValue = "WORLD!";

            System.out.println(returnValue + " / " + currentThreadName);

            return message + " " + returnValue;

        });

    }

}
