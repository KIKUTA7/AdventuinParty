package pgdp.adventuin;

public enum Language {
    GERMAN,ENGLISH;
    public String getLocalizedChristmasGreeting (String greeterName)
    {
        if(this == GERMAN) return "Fröhliche Weihnachten wünscht dir " + greeterName + "!";
        else return greeterName + " " + "wishes you a Marry Christmas!";
    }
}
