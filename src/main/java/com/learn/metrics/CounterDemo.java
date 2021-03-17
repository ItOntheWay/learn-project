package com.learn.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class CounterDemo {
    private static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {
        for(int num =0; num<200;num++){
            test();
        }
    }

    public static void test()throws InterruptedException{
        MetricRegistry metrics = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(5, TimeUnit.SECONDS);
        Counter counter = metrics.counter(name(CounterDemo.class, "count-job"));
//        for (int num = 1; num<200; num++) {
            Thread.sleep(1000);
            double d = random.nextDouble();
            System.out.println("---d---"+d);
            if (d > 0.9) {
                counter.inc();
                System.out.println("---大---");
            } else {
                /*counter.dec();
                System.out.println("---小---");*/
            }
//        }
    }
}
