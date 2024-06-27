package Model;

public class Player {
    private String name;
    private String number;
    private Position position;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}

