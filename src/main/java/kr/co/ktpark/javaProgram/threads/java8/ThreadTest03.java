package kr.co.ktpark.javaProgram.threads.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ThreadTest03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. 두 개 이상 쓰레드 연결시켜서 사용하기
        dobuleLinkThreadProcess();

        // 2. 두 개 이상 쓰레드 연결시켜서 사용하기
        //    + 결과값 각각 모두 받아오기
        arrayListGetResultsProcess();

        // 3. 두 개 이상 쓰레드 연결시켜서 사용하기
        //    + 결과값 아무거나 하나 받아오기
        doubleLinkWithGetAnyResultProcess();

    }

    private static void doubleLinkWithGetAnyResultProcess() throws InterruptedException, ExecutionException {

        CompletableFuture<String> parkKyungTaek = CompletableFuture.supplyAsync(() -> "Park Kyung Taek");
        CompletableFuture<String> leeJinHyo = CompletableFuture.supplyAsync(() -> "Lee Jin Hyo");

        // 둘 다 호출 하는데, 둘 중 먼저 받는 결과값 출력 (아무거나 출력)
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.anyOf(parkKyungTaek, leeJinHyo).thenAccept(System.out::println);
        voidCompletableFuture.get();

    }

    private static void arrayListGetResultsProcess() throws InterruptedException, ExecutionException {

        // 두 개 이상 쓰레드 연결시켜서 사용하기
        //    + 결과값 각각 모두 받아오기
        CompletableFuture<String> parkKyungTaek = CompletableFuture.supplyAsync(() -> "Park Kyung Taek");
        CompletableFuture<String> leeJinHyo = CompletableFuture.supplyAsync(() -> "Lee Jin Hyo");

        List<CompletableFuture<String>> futureList = Arrays.asList(parkKyungTaek, leeJinHyo);
        CompletableFuture[] futureListArray = futureList.toArray(new CompletableFuture[futureList.size()]);

        CompletableFuture<List<String>> resultFutureList = CompletableFuture.allOf(futureListArray)
                .thenApply((temp) -> { // 결과는 null 임 ( 무의미 )
                    // 여기선 이미 모든 Future 작업들이 끝낫음
                    return futureList.stream()
                            .map(resultFuture -> resultFuture.join()) // Return 결과값들 있음. | get : CheckedException / join : UnCheckedException
                            .collect(Collectors.toList());
                });

        List<String> threadResults = resultFutureList.get();
        threadResults.forEach(System.out::println);

    }

    private static void dobuleLinkThreadProcess() throws InterruptedException, ExecutionException {
        
        // 두 개 이상 쓰레드 연결시켜서 사용하기
        
        CompletableFuture<String> parkKyungTaek = CompletableFuture.supplyAsync(() -> {

            String currentThreadName = Thread.currentThread().getName();
            String returnValue = "Park Kyung Taek";

            System.out.println(returnValue + " / " + currentThreadName);

            return returnValue;

        });

        CompletableFuture<String> leeJinHyo = CompletableFuture.supplyAsync(() -> {

            String currentThreadName = Thread.currentThread().getName();
            String returnValue = "Lee Jin Hyo";

            System.out.println(returnValue + " / " + currentThreadName);

            return returnValue;

        });

        // 두 결과 (kyungtaek, jinhyo) 값 모두 받은 경우 람다 내부 메소드 실행됨
        // 2개 쓰레드인 경우
        CompletableFuture<String> completableFuture = parkKyungTaek.thenCombine(leeJinHyo, (ktp, jhl) -> ktp + " Love " + jhl);
        completableFuture.get();

        // 2개 이상 쓰레드인 경우
        // 그러나 각 쓰레드 결과 값을 받아오지는 못함 (thenAccept result : null)
        // 결과 값이 무의미 하다.
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(parkKyungTaek, leeJinHyo).thenAccept(System.out::println);
        voidCompletableFuture.get();

    }

}
