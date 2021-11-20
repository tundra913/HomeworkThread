import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int result = 0;
        List<MyCallable> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futureList.add(new MyCallable(i + 1));
        }
        try {
            List<Future<Integer>> futures = pool.invokeAll(futureList);
            for (Future<Integer> future : futures) {
                try {
                    result = result + future.get();
                }  catch (ExecutionException ee) {
                    ee.printStackTrace();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println("Выведенно сообщений по всем задачам " + result);
        pool.shutdown();
    }
}