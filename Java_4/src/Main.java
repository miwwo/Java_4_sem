import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Создаем список чисел
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Создаем ExecutorService с фиксированным количеством потоков
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Создаем CompletableFuture для каждого числа в списке
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int number : numbers) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> number * 2, executor);
            futures.add(future);
        }

        // Объединяем результаты CompletableFuture в список
        List<Integer> results = new ArrayList<>();
        for (CompletableFuture<Integer> future : futures) {
            results.add(future.join());
        }

        // Выводим результаты
        System.out.println(results);

        // Останавливаем ExecutorService
        executor.shutdown();
    }
}
