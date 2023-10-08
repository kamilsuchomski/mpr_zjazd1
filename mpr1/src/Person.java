public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age){
        if (age < 0){
            throw new InvalidAgeException("Wiek nie moze byc mniejszy niz 0.");
        }
        if (age > 100){
            throw new InvalidAgeException("Wiek nie moze byc wiekszy niz 100.");
        }
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        if (age < 0){
            throw new InvalidAgeException("Wiek nie moze byc mniejszy niz 0.");
        }
        if (age > 100){
            throw new InvalidAgeException("Wiek nie moze byc wiekszy niz 100.");
        }

        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return (getName() + " " + getAge());
    }
}
