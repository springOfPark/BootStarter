package kr.co.ktpark.javaProgram.threads.oldJava;

public class ThreadTest01 {

    public static void main(String[] args) throws InterruptedException {

        // 1. Thread 상속
        runThread01();

        // 2. Runnable 구현
        runThread02();

        System.out.println("Main Thread : " + Thread.currentThread().getName());

    }

    // Thread 실행 방법 02. 함수형 인터페이스 : Runnable 구현 (람다)
    private static void runThread02() throws InterruptedException {

        Thread thread = new Thread(() -> {

            String threadName = Thread.currentThread().getName();

            System.out.println("Run Thread 02 [Runnable Start] : " + threadName);

            while (true) {

                try {
                    Thread.sleep(1000L); // Sleep 을 통해 다른 쓰레드 먼저 처리됨 (위 로그는 먼저 출력 될 수 있다)
                    System.out.println("Run Thread 02 [Runnable Process] : " + threadName);
                } catch (InterruptedException e) { // 자는동안(Sleep 시간) 이 쓰레드를 깨운 경우 (꺠우는 방법이 있음)
                    e.printStackTrace();
                    System.out.println("스레드 강제 종료!");
                    return; // 여기서 강제 종료 (하지 않아도 됨)
                }

            }

        });

        thread.start();

        Thread.sleep(3000L);
        thread.interrupt(); // 종료 오퍼레이션이 아닌 단지 깨우는 메소드

        /*
        try {
            thread.join(); // 해당 Thread 종로 후 아래 소스가 적용
            System.out.println(thread + " is Finished");
            System.out.println("쓰레드 종료 후 실행됩니다.");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
         */

    }

    // Thread 실행 방법 01. Thread Class Extends 및 Override Run Method
    private static void runThread01() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Run Thread 01 [Extends Thread] : " + Thread.currentThread().getName());
        }
    }

}
