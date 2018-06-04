package hello;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;

public class CallableWorld implements Callable<String> {
    Semaphore sem = new Semaphore(1);
    //ReadWriteLock rwl = new ReadWriteLock().readLock();

    @Override
    public String call() throws Exception {
        return null;
    }
}
