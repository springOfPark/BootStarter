package kr.co.ktpark.javaProgram.threads.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadTest04Exception {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        processWithException();

        processWithResultAndExceptionHandle();

    }

    private static void processWithResultAndExceptionHandle() {

        boolean throwError = true;

        CompletableFuture<String> parkKyungTaek = CompletableFuture.supplyAsync(() -> {

            if (throwError) {
                throw new IllegalArgumentException();
            }

            return "Park Kyung Taek";

        }).handle((result, ex) -> {
            // result : 정상적인 처리 후 결과값
            // ex : 오류난 경우 Exception Stack
            String returnValue = "OK : " + result;
            if (ex != null) {
                returnValue = "ERROR";
            }

            return returnValue;

        });

    }

    private static void processWithException() throws InterruptedException, ExecutionException {

        boolean throwError = true;

        CompletableFuture<String> parkKyungTaek = CompletableFuture.supplyAsync(() -> {

            if (throwError) {
                throw new IllegalArgumentException();
            }

            return "Park Kyung Taek";

        }).exceptionally(ex -> {
            // 에러 타입 받아서 리턴 가능
            ex.printStackTrace();
            return "ERROR";
        });

        String result = parkKyungTaek.get();
        System.out.println(result);

        if ("ERROR".equals(result)) {
            // DO 에러 처리..
        }

    }

}
