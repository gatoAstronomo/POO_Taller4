package Model;

public class Player {
    private String name;
    private String number;
    private Position position;

    public Player(String number, String name, Position position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }

    public Player() {
    }

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
