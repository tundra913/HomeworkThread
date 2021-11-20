import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    int name;

    public MyCallable(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    @Override
    public Integer call() throws InterruptedException {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            System.out.println("Я поток " + getName() + ". " + "Всем привет!");
            count++;
        }
        return count;
    }
}