package be.hogent.koifarm.koifarm;

public abstract class Person {
    private int personId;
    private int personCount;
    private String name;

    public Person(String name) {
        this.name = name;
        CreateId();
    }

    public int CreateId(){
        this.personId = personCount;
        personCount++;
        return personId;
    }
}
