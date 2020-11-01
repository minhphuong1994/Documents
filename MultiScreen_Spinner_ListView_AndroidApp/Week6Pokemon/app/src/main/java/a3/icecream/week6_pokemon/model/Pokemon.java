package a3.icecream.week6_pokemon.model;

public class Pokemon {
    private String name;
    private String type;
    private String image;
    private int baseExp;

    public Pokemon(String name, String type, String image, int baseExp) {
        this.name = name;
        this.type = type;
        this.image = image;
        this.baseExp = baseExp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public int getBaseExp() {
        return baseExp;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", baseExp=" + baseExp +
                '}';
    }
}
