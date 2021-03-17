package com.learn.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(5,true);

    public static void main(String[] args){

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }
    }

    public static void test(){
        try{
            //请求一个信号
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"进来了");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"走了");
            //释放一个信号
            semaphore.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
