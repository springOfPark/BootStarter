package kr.co.ktpark.javaProgram.threads.oldJava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Runnable : Return void
 * Callable : Return Type
 */

public class ThreadTest03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Callable, Future
        testCallableFuture();

        // Invoke All, Invoke Any
        testGroupingCallableThreads();

    }

    private static void testGroupingCallableThreads() throws InterruptedException, ExecutionException {
        Callable<String> hello = () -> {

            Thread.sleep(2000L);
            return "Hello";

        };

        Callable<String> java = () -> {

            Thread.sleep(3000L);
            return "Java";

        };

        Callable<String> jvm = () -> {

            Thread.sleep(1000L);
            return "JVM";

        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // invokeAll : 모든 쓰레드 처리가 끝날때까지 대기 후, 한번에 출력함
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, jvm));
        for (Future<String> result : futures) {
            System.out.println(result.get());
        }

        // invokeAny : 모든 쓰레드 중 가장 빨리 끝나는 쓰레드 결과값 반환
        String resultString = executorService.invokeAny(Arrays.asList(hello, java, jvm)); // Blocking Call
        System.out.println("Invoke Any : " + resultString);

        executorService.shutdown();
    }

    private static void testCallableFuture() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> hello = () -> {

            Thread.sleep(3000L);
            return "Hello";

        };

        Future<String> submit = executorService.submit(hello);

        System.out.println("Get 이전까지 실행이 됨.");
        System.out.println("쓰레드가 끝낫나? 안끝낫나? : " + submit.isDone()); // false

        // submit.cancel(true); // true : 현재 진행중인 작업을 Interrupot 하면서 종료 | false : 작업 기다리고 종료
        // cancel 을 할 경우 밑에서 .get() 을 할 수 없다.

        String resultString = submit.get(); // Blocking Call (get 만난 순간 STOP되고, 결과값을 받을때까지 기다림)

        System.out.println("쓰레드가 끝낫나? 안끝낫나? : " + submit.isDone()); // true
        System.out.println("Result : " + resultString);

        executorService.shutdown();
    }

}
