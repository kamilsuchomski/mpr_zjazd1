import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        try {
//            Person person = new Person("Jan", 20);
//        } catch (InvalidAgeException e) {
//            System.out.println("Zlapano wyjatek: " + e.getMessage());
//        }
//
//        try {
//            Person person2 = new Person("Piotr", -5);
//        } catch (InvalidAgeException e) {
//            System.out.println("Zlapano wyjatek: " + e.getMessage());
//        }

        Person person = new Person("Jan", 20);
        Person person2 = new Person("Piotr", 65);
        Person person3 = new Person("Kuba", 24);

        person2.setName("Ania");
        person.setAge(43);

//        System.out.println("Osoba: " + person.getName() + " wiek: " + person.getAge());
//        System.out.println("Osoba: " + person2.getName() + " wiek: " + person2.getAge());
//
//        System.out.println("Osoba :" + person);

        List<Person> immutablePersonList = List.of(person, person2, person3, person);

        //imutablePersonList.add(person);  ---> rzuca wyjatek, nie mozna dodawac elementow do listy niemutowalnej

        System.out.println("Lista niemutowalna: " + immutablePersonList);

        List<Person> mutablePersonList = new ArrayList<>();
        mutablePersonList.add(person);
        mutablePersonList.add(person2);
        mutablePersonList.add(person3);

        System.out.println("Lista mutowalna: " + mutablePersonList);

        Set<Person> immutablePersonSet = Set.of(person, person2, person3);

        //imutablePersonSet.add(person);  ---> rzuca wyjatek, nie mozna dodawac elementow do setu niemutowalnego

        System.out.println("Set niemutowalny: " + immutablePersonSet);

        Set<Person> mutablePersonSet = new HashSet<>();
        mutablePersonSet.add(person);
        mutablePersonSet.add(person2);
        mutablePersonSet.add(person3);
        mutablePersonSet.add(person);

        System.out.println("Set mutowalny" + mutablePersonSet);

        Map<Integer, Person> immutablePersonMap = Map.of(1, person, 2, person2, 3, person3);

        System.out.println("Mapa niemutowalna: " + immutablePersonMap);

        Map<String, Person> mutablePersonMap = new HashMap<>();
        mutablePersonMap.put("A", person);
        mutablePersonMap.put("B", person2);
        mutablePersonMap.put("C", person3);
        mutablePersonMap.put("A", person2);

        System.out.println("Mapa mutowalna: " + mutablePersonMap);

        // Streamy

        List<Integer> ageList = immutablePersonList.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Integer ageSum = ageList.stream()
                .reduce(0, (sum, value) -> sum + value);

        System.out.println("suma wieku: " + ageSum);

        double averageAge = (double) ageSum / ageList.size();

        System.out.println("Srednia wieku: " + averageAge);

        Integer ageSum1 = immutablePersonList.stream()
                .map(p -> p.getAge())
                .reduce(0, (sum, value) -> sum + value);

//        Integer ageSum1 = immutablePersonList.stream()            to samo co wyzej, inny zapis
//                .map(Person::getAge)
//                .reduce(0, (sum, value) -> sum + value);

        System.out.println("Suma stream chain: " + ageSum1);


        //Nowa lista, tylko imiona

        List<String> nameList = immutablePersonList.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        System.out.println("Nowa lista, tylko imiona: " + nameList);

        //Lista osob w wieku powyzej 25 lat

        List<Person> ageOver25List = immutablePersonList.stream()
                .filter(p -> (p.getAge() > 25))
                .collect(Collectors.toList());

        System.out.println("Lista osob w wieku powyzej 25 lat: " + ageOver25List);

        //Lista osob alfabetycznie
        List<Person> sortedByNamePersonList = immutablePersonList.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        System.out.println("Alfabetyczna lista osob: " + sortedByNamePersonList);

        //Wypisanie imion i wieku (forEach)

        immutablePersonList.stream()
                .forEach(System.out::println);

        //Osoba namlodsza i najstarsza + wypisanie w konsoli

//        List<Person> emptyList = Collections.emptyList();

        Optional<Person> minAgePerson = immutablePersonList.stream()
                .min(Comparator.comparingInt(Person::getAge));

        Optional<Person> maxAgePerson = immutablePersonList.stream()
                .max(Comparator.comparingInt(Person::getAge));

        minAgePerson.ifPresentOrElse(p -> System.out.println("Minimalny wiek to: " + p.getAge()), ()-> System.out.println("Nie odnaleziono zadnej osoby."));

        maxAgePerson.ifPresentOrElse(p -> System.out.println("Maksymalny wiek to: " + p.getAge()), ()-> System.out.println("Nie odnaleziono zadnej osoby."));

    }
}