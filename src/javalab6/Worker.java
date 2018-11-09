package javalab6;

//: TIEJ:X1:Worker.java
// Instances of Worker are pooled in threadpool
// {Clean: WorkerErr.log, WorkerErr.log.lck}
// {RunByHand}
import java.io.*;
import java.util.logging.*;

public class Worker extends Thread {
    public static final Logger logger = Logger.getLogger("Worker");
    private String workerId;
    private Runnable task;
    // ���������� ������ �� ��� ����� � ������� ���������� ����, �����
    // ���� ����� �������� ���� � ��� ����� �� ���������� ������.
    private ThreadPool threadpool;
    static {
        try {
            logger.setUseParentHandlers(false);
            FileHandler ferr = new FileHandler("WorkerErr.log");
            ferr.setFormatter(new SimpleFormatter());
            logger.addHandler(ferr);
        }
        catch (IOException e) {
            System.out.println("Logger not initialized..");
        }
    }

    public Worker(String id, ThreadPool pool) {
        workerId = id;
        threadpool = pool;
        start();
    }

    // ThreadPool, ����� ������ � ���������� ������, ���������� ���� �����
    // ��� ������������� ������ Worker-����. ����� ���� ��� ���������
    // ������ (���� Runnable) �� ����� ����������� ��������� �����
    // run() �� ������ ���������� ������.
    public void setTask(Runnable t) {
        task = t;
        synchronized (this) {
            notify();
        }
    }

    public void run() {
        try {
            while (!threadpool.isStopped()) {
                synchronized (this) {
                    if (task != null) {
                        try {
                            task.run(); // ��������� ������
                        }
                        catch (Exception e) {
                            logger.log(Level.SEVERE,
                                       "Exception in source Runnable task", e);
                        }
                        // ���������� ���� � ��� �����
                        threadpool.putWorker(this);
                    }
                    wait();
                }
            }
            System.out.println(this + " Stopped");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Worker : " + workerId;
    }
} // /:~
