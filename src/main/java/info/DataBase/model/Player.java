package info.DataBase.model;

public class Player {
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Player(String name, int number){
        this.name = name;
        this.number = number;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    private int id;
    private String name;
    private int number;
    private static int idCounter = 1;
}
