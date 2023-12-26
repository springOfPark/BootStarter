package kr.co.ktpark.javaProgram.threads.oldJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadTest02 {

    public static void main(String[] args) {

        // 쓰레드 스케쥴 처리
        doScheduledThread();

        // 기본 쓰레드 처리
        // ExecutorService executorService = Executors.newSingleThreadExecutor(); // 하나의 스레드
        ExecutorService executorService = Executors.newFixedThreadPool(2); // 2개 스레드
        // 2개의 스레드에서 번갈아가면서 5개의 작업 처리
        // Thread Pool Task 들을 BLocking Queue 에 쌓았다가 하나씩 처리
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("Park"));
        executorService.submit(getRunnable("Kyung"));
        executorService.submit(getRunnable("Taek"));
        executorService.submit(getRunnable("Good"));

        // ExecutorService 는 명시적으로 종료해야 한다.
        executorService.shutdown(); // Graceful Shutdown : 현재 진행중인 작업은 끝까지 마치고 종료한다.
        // executorService.shutdownNow(); // 강제 종료

    }

    private static void doScheduledThread() {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(getRunnable("스케쥴 처리 반복"), 1, 2, TimeUnit.SECONDS); // 1초 기다렸다가 2초에 한번씩 실행
        // scheduleAtFixedRate : shutdown() 하면 안됨
        
        // scheduledExecutorService.schedule(getRunnable("스케쥴 처리"), 3, TimeUnit.SECONDS); // 3초 후 한 번 실행
        // scheduledExecutorService.shutdown();


    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " / Thread : " + Thread.currentThread().getName());
    }

}
