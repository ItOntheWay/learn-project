package com.learn.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CounterTest {
    private static Queue<String> queue = new LinkedBlockingQueue<String>();
    private static Counter pendingJobs;
    private static Random random = new Random();

    public static void addJob(String job) {
        pendingJobs.inc();
        queue.offer(job);
    }

    public static String takeJob() {
        pendingJobs.dec();
        return queue.poll();
    }

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();

        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        pendingJobs = registry.counter("pending.jobs.size");
        for (int num = 1; num<200; num++) {
            Thread.sleep(1000);
            double d = random.nextDouble();
            System.out.println("---d---"+d);
            if (d > 0.8) {
                takeJob();
                System.out.println("---大---"+num);
            } else {
                addJob("Job-" + num);
                System.out.println("---小---"+num);
            }
        }
    }
}
