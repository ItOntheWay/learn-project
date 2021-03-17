package com.learn.delayed;

import java.util.concurrent.DelayQueue;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/11/25 10:12
 */
public class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
