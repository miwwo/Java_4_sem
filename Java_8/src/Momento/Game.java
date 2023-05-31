package Momento;

public class Game{
    private int level;
    private int score;

    public void setLevel(int level){
        this.level = level;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public GameMemento save() {
        return new GameMemento(level, score);
    }

    public void load(GameMemento memento) {
        this.level = memento.getLevel();
        this.score = memento.getScore();
    }
}
    /*Паттерн Хранитель (также известный как Memento, Token, Лексема) позволяет не нарушая инкапсуляцию
    зафиксировать и сохранить внутреннее состояния объекта так, чтобы позднее восстановить его в этом состоянии*/
class GameMemento {
    private final int level;
    private final int score;

    public GameMemento(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}
