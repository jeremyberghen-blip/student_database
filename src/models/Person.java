package models;

public class Person {
    protected String name;
    protected String personalId;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getID(){
        return personalId;
    }

    public void setId(String id){
        this.personalId = id;
    }

    public String introduce(){
        return "Hello, my name is " + name + " and my id is " + personalId;
    }

    public Person(String name, String personalId){
        this.name = name;
        this.personalId = personalId;
    }

    @Override
    public String toString() {
        return name + " " + personalId;
    }
}