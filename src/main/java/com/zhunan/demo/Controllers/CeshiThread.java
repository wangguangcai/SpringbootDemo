package com.zhunan.demo.Controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CeshiThread {

    public static void main(String[] args) {
       /* //创建两个线程
        ThreadDemo td=new ThreadDemo("xiancheng1");
        ThreadDemo td1=new ThreadDemo("xiancheng2");
        //执行多线程特有方法，如果使用td.run();也会执行，但会以单线程方式执行。
        td.start();
        td1.start();
        //主线程
        for(int i=0;i<5;i++){
            System.out.println("main" + ":run" + i);
        }*/
      /*RunTest rt=new RunTest();
      Thread td=new Thread(rt);
      Thread td1=new Thread(rt);
      td.start();
      td1.start();*/

      //创建固定线程个数为十个的线程池
        ExecutorService executorService= Executors.newFixedThreadPool(10);
      //new一个Runnable接口的对象
        RunTest rt=new RunTest();
        RunTest rt1=new RunTest();

        //执行线程，最多十个
        executorService.execute(rt);
        executorService.execute(rt1);

        //关闭线程池
        executorService.shutdown();
    }

}

class ThreadDemo extends Thread{
    //设置县城名称
    ThreadDemo(String name){
        super(name);
    }

    //重写run方法
    public void run(){
        /*for(int i=0;i<5;i++){
            System.out.println(this.getName() + "：run" + i);
        }*/
        int tick=10;
        while (true){
           // synchronized (this) {
                if (tick > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "..." + tick--);
                }
           // }
        }
    }

}

class RunTest implements Runnable{
    private int tick=10;
    //覆盖Runnable接口中的run方法,并将线程要运行的代码放在该run方法中。
    public void run(){
        while (true){
            synchronized (this) {
                if (tick > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "..." + tick--);
                }
            }
        }
    }
}
