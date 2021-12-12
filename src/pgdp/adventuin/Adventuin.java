package pgdp.adventuin;

import pgdp.color.RgbColor;

public class Adventuin {
    private String name ;
    private int height;
    private RgbColor color;
    private HatType hatType;
    private Language language;
    public Adventuin(String name,int height,RgbColor color , HatType hatType, Language language )
    {
        this.name = name;
        this.height = height;
        this.color = color;
        this.hatType = hatType;
        this.language = language;
    }

    public RgbColor getColor() {
        return color;
    }

    public HatType getHatType() {
        return hatType;
    }

    public int getHeight() {
        return height;
    }

    public Language getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }


}
