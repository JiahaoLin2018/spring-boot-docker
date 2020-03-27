package com.neo.controller;

import org.springframework.beans.factory.InitializingBean;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.util.concurrent.DelayQueue;
 import java.util.concurrent.Delayed;
 import java.util.concurrent.TimeUnit;

       public class TestMain5  implements InitializingBean {


         DelayQueue<DelayTask> dq = new DelayQueue();
          public static void main(String[] args) throws Exception {
         //入队四个元素，注意它们的延迟时间单位不一样。

         /*
         打印顺序：
         DelayTask{delay=1000, unit=NANOSECONDS}
         DelayTask{delay=700000000, unit=MILLISECONDS}
         DelayTask{delay=5000000000, unit=SECONDS}
         DelayTask{delay=120000000000, unit=MINUTES}
         */
           }

           @Override
           public void afterPropertiesSet() throws Exception {
           }
       }

      class DelayTask implements Delayed {

          private long delay; //延迟多少纳秒开始执行
     private TimeUnit unit;

    public DelayTask(long delay, TimeUnit unit){
            this.unit = unit;
            this.delay = System.nanoTime() + TimeUnit.NANOSECONDS.convert( + delay, unit);//统一转换成纳秒计数
        }

    @Override
     public long getDelay(TimeUnit unit) {//延迟剩余时间，单位unit指定
               return unit.convert(delay - System.nanoTime(), TimeUnit.NANOSECONDS);
           }

       @Override
     public int compareTo(Delayed o) {//基于getDelay实时延迟剩余时间进行比较
              if(this.getDelay(TimeUnit.NANOSECONDS) < o.getDelay(TimeUnit.NANOSECONDS)) //都换算成纳秒计算
                  return -1;
          else if(this.getDelay(TimeUnit.NANOSECONDS) > o.getDelay(TimeUnit.NANOSECONDS)) //都换算成纳秒计算
                  return 1;
              else
                  return 0;
          }

      @Override
     public String toString() {
                  return "DelayTask{" +
                              "delay=" + delay +
                              ", unit=" + unit +
                              '}';
              }
 }
