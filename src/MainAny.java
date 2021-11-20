import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainAny {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int result = 0;
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tasks.add(new MyCallable(i + 1));
        }
        try {
            result = pool.invokeAny(tasks);
        } catch (
                ExecutionException ee) {
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Выведенно сообщений по самой быстрой задаче " + result);
        pool.shutdown();
    }
}
