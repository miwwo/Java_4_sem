package Momento;

public class GameTest {
    public static void main(String[] args) {
        Game game = new Game();

        game.setLevel(3);
        game.setScore(1500);
        // сохраняем игру
        GameMemento memento = game.save();

        System.out.println("Your level is " + game.getLevel());
        System.out.println("Your score is " + game.getScore());
        System.out.println("-----------------------------------------------");

        // изменяем состояние игры
        game.setLevel(4);
        game.setScore(2000);
        // загружаем сохраненное состояние игры
        game.load(memento);

        System.out.println("Your level is " + game.getLevel());
        System.out.println("Your score is " + game.getScore());
    }
}
