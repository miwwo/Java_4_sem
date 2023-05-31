/*5) Сортировка по возрасту в обратном порядке, фильтрация по имени
«начинается с А», сортировка по дате рождения, расчет среднего веса.*/

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class App {
    List<Human> people;

    public List<Human> getPeople() {
        return people;
    }

    public App() {
        people = new ArrayList<>();
        people.add(new Human(
                "Kirill",
                "Shapovalov",
                LocalDate.of(2003, Month.APRIL, 1),
                100));
        people.add(new Human(
                "Aidar",
                "Alinbekov",
                LocalDate.of(2000, Month.DECEMBER, 14),
                15));
        people.add(new Human(
                "Alsu",
                "Safina",
                LocalDate.of(1889, Month.NOVEMBER, 11),
                36));

        people.add(new Human(
                "Emiliya",
                "Galihanova",
                LocalDate.of(2003, Month.JANUARY, 16),
                20));
    }

    //14)   Сортировка по сумме веса и возраста, фильтрация по весу кратно 5,
//          выбор первых четырёх элементов, конкатенация имён через пробел.
    public static void main(String[] args) {
        App app = new App();

        System.out.println("BEFORE-----------------------------------------------");
        Stream<Human> stream0 = app.getPeople().stream();
        stream0.forEach(System.out::println);

        System.out.println("SORTING----------------------------------------------");
        Stream<Human> stream1 = app.getPeople().stream();
        stream1.sorted(Comparator.comparingInt(Human::getAge).reversed()).forEach(System.out::println);

        System.out.println("FILTERING-------------------------  -------------------");
        Stream<Human> stream2 = app.getPeople().stream();
        stream2.filter(o -> o.getFirstName().startsWith("A")).forEach(System.out::println);

        System.out.println("BIRTHDATE----------------------------------------------");
        Stream<Human> stream3 = app.getPeople().stream();
        stream3.sorted(Comparator.comparing(Human::getBirthDate)).forEach(System.out::println);

        System.out.println("AVERAGE WEIGH----------------------------------------");
        Stream<Human> stream4 = app.getPeople().stream();
        System.out.println(stream4.mapToInt(Human::getWeight).average().getAsDouble());
        /*System.out.println(stream4.mapToDouble(Human::getWeight).sum()/app.getPeople().size());*/
        /*System.out.println(stream4.mapToDouble(Human::getWeight).reduce((x,y) -> x + y).get()/app.getPeople().size());*/

    }
}