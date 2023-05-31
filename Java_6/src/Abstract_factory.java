interface Door {
    public void getDescription();
}

class WoodenDoor implements Door {
    public void getDescription() {
        System.out.println("I am a wooden door");
    }
}

class IronDoor implements Door {
    public void getDescription() {
        System.out.println("I am an iron door");
    }
}
interface DoorFittingExpert {
    public void getDescription();
}

class Welder implements DoorFittingExpert {
    public void getDescription() {
        System.out.println("I can only fit iron doors");
    }
}

class Carpenter implements DoorFittingExpert {
    public void getDescription() {
        System.out.println("I can only fit wooden doors");
    }
}
interface DoorFactory {
    public Door makeDoor();
    public DoorFittingExpert makeFittingExpert();
}

// Фабрика деревянных дверей возвращает плотника и деревянную дверь
class WoodenDoorFactory implements DoorFactory {
    public Door makeDoor() {
        return new WoodenDoor();
    }

    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}

// Фабрика стальных дверей возвращает стальную дверь и сварщика
class IronDoorFactory implements DoorFactory {
    public Door makeDoor() {
        return new IronDoor();
    }

    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}
public class Abstract_factory {
    public static void main(String[] args) {
        WoodenDoorFactory woodenFactory = new WoodenDoorFactory();

        Door door = woodenFactory.makeDoor();
        DoorFittingExpert expert = woodenFactory.makeFittingExpert();

        door.getDescription();
        expert.getDescription();


        IronDoorFactory ironFactory = new IronDoorFactory();

        door = ironFactory.makeDoor();
        expert = ironFactory.makeFittingExpert();

        door.getDescription();
        expert.getDescription();
    }
}

