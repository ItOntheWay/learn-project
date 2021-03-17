package com.learn.delayed;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/11/25 10:12
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        // 创建延时队列
        DelayQueue<Message> queue = new DelayQueue<Message>();
        // 添加延时消息,m1 延时3s
        Message m1 = new Message(1, "world", 3000);
        // 添加延时消息,m2 延时10s
        Message m2 = new Message(2, "hello", 10000);
        Message m3 = new Message(3, "java", 5000);
//        Message m4 = new Message(3, "java", 5000);
        //将延时消息放到延时队列中
        queue.offer(m3);
//        queue.offer(m4);
        queue.offer(m2);
        queue.offer(m1);
        System.out.println("...size..."+queue.size());
//        boolean res = queue.remove(m4);
//        System.out.println("..."+res+"..."+queue.size());
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        /*ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        exec.shutdown();*/

        //手动定义线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        int size = queue.size();
        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        executorService.execute(new Consumer(queue));
        executorService.shutdown();
    }
}
