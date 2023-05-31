
// Фабричный метод

interface Animal
{
    public void makeSound();
}

class Kittie implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Meow ~");
    }
}

class Doggy implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Wouf ~");
    }
}

abstract class Pet
{
    public abstract Animal bePet();

    public void sayHello(){
        Animal animal = bePet();
        animal.makeSound();
    }

}

class petKitten extends Pet{

    @Override
    public Animal bePet() {
        return new Kittie();
    }
}
class petDoggy extends Pet{

    @Override
    public Animal bePet() {
        return new Doggy();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        petKitten Fluffy = new petKitten();
        Fluffy.sayHello();

        petDoggy Doger = new petDoggy();
        Doger.sayHello();

    }
}