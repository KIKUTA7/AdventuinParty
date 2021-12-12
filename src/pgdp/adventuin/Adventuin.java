package pgdp.adventuin;

import pgdp.color.RgbColor;

public class Adventuin {
    private final String name ;
    private final int size;
    private final RgbColor color;
    private final HatType hatType;
    private final Language language;
    public Adventuin(String name,int size,RgbColor color , HatType hatType, Language language )
    {
        this.name = name;
        this.size = size;
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
        return size;
    }

    public Language getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }


}
