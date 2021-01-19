package corp.dean.fruits.model;

public class Fruit {
    private String fruitName;
    private String fruitColour;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitColour() {
        return fruitColour;
    }

    public void setFruitColour(String fruitColour) {
        this.fruitColour = fruitColour;
    }

    public Fruit(String fruitName, String fruitColour) {
        this.fruitName = fruitName;
        this.fruitColour = fruitColour;
    }

    public Fruit() {
    }

    
}
