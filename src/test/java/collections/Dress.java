package collections;

public class Dress {
    private String color;
    private String size;
    private String name;

    public Dress (String color, String size, String name){
        this.color = color;
        this.size = size;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
