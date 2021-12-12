package pgdp.adventuin;

import pgdp.color.RgbColor;

public class Adventuin {
    private final String name ;
    private final int height;
    private final RgbColor color;
    private final HatType hatType;
    private final Language language;
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
