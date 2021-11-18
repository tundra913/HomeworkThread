public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("main group");
        MyThread myThread1 = new MyThread(group, "1");
        MyThread myThread2 = new MyThread(group, "2");
        MyThread myThread3 = new MyThread(group, "3");
        MyThread myThread4 = new MyThread(group, "4");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        Thread.sleep(15000);
        group.interrupt();
    }
}
