//Ленивая инициализация (не потокобезопасная()

/*
public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
*/

// Simple Solution
/*
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
*/
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Привет, мир!");
    }
}