package javalab6;

//: TIEJ:X1:ThreadPool.java
// ��� �����, ������� ��������� ������.
// {RunByHand}
import java.util.*;

public class ThreadPool extends Thread {
    private static final int DEFAULT_NUM_WORKERS = 5;
    private LinkedList workerPool = new LinkedList(),
            taskList = new LinkedList();
    private boolean stopped = false;

    public ThreadPool() {
        this(DEFAULT_NUM_WORKERS);
    }

    public ThreadPool(int numOfWorkers) {
        for (int i = 0; i < numOfWorkers; i++)
            workerPool.add(new Worker("" + i, this));
        start();
    }

    public void run() {
        try {
            while (!stopped) {
                if (taskList.isEmpty()) {
                    synchronized (taskList) {
                        // ���� ������� ������, ���������, ���� ����� ���������
                        // ������
                        taskList.wait();
                    }
                }
                else if (workerPool.isEmpty()) {
                    synchronized (workerPool) {
                        // ���� ��� ������� �����, ���������, ����
                        // ���� �� ��������
                        workerPool.wait();
                    }
                }
                // ��������� ��������� ������ �� ���������� �����
                getWorker().setTask((Runnable) taskList.removeLast());
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Runnable task) {
        taskList.addFirst(task);
        synchronized (taskList) {
            taskList.notify(); // ���� ��������� ����� ������, ����������
        }
    }

    public void putWorker(Worker worker) {
        workerPool.addFirst(worker);
        // ����� ����� ���� ������, ����� �� ������ ����� ��� �� 5 �����,
        // � ����� ����������� ������. ��� ���������� �����, ����� ���������
        // ������� ����,
        // �� �� ��� (���������), ����� ������ ��������� ��� �����.
        // ��� �������, ��� ������� ���������� ��������� ������� ���� � ����
        // �����
        // ������� ��� ���� �������� ����������� � ������������
        // ���� ThreadPool, ��������� ��� �����
        synchronized (workerPool) {
            workerPool.notify();
        }
    }

    private Worker getWorker() {
        return (Worker) workerPool.removeLast();
    }

    public boolean isStopped() {
        return stopped;
    }

    public void stopThreads() {
        stopped = true;
        Iterator it = workerPool.iterator();
        while (it.hasNext()) {
            Worker w = (Worker) it.next();
            synchronized (w) {
                w.notify();
            }
        }
    } // Junit test

    public void testThreadPool() {
        ThreadPool tp = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            tp.addTask(new Runnable() {
                public void run() {
                    System.out.println("A");
                }
            });
        }
        tp.stopThreads();
    }
} // /:~
