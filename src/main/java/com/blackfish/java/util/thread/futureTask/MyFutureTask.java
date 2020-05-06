package com.blackfish.java.util.thread.futureTask;

import java.util.concurrent.*;

/**
 * @Auther: shuyiwei
 * @Date: 2020/5/6 19:51
 * @Description:
 */
public class MyFutureTask implements Future ,Runnable {

    @Override
    public void run() {

    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
