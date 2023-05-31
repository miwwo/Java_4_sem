import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SynchronizedList<Integer> list = new SynchronizedList<>();
        SemaphoreSet<Integer> set = new SemaphoreSet<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 29; i++) {
                list.add(i);
            }
        });
        Thread thread2 =  new Thread(() -> {
            for (int i = 29; i < 60; i++) {
                list.add(i);
            }
        });

        thread1.start();
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 29; i++) {
                set.add(i);
            }
        });
        Thread thread4 =  new Thread(() -> {
            for (int i = 29; i < 60; i++) {
                set.add(i);
            }
        });

        thread3.start();
        thread4.start();

        System.out.println("SynchronizedList.");
        System.out.println("SynchronizedList size = " + list.size());
        for (var num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("SemaphoreSet.");
        System.out.println("SemaphoreSet size = " + set.size());
        for (var num: set) {
            System.out.print(num + " ");
        }
        System.out.println();


    }
}