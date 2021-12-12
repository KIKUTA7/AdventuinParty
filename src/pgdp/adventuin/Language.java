package pgdp.adventuin;

public enum Language {
    GERMAN,ENGLISH,ARMENIAN;
    public String getLocalizedChristmasGreeting (String greeterName)
    {
        if(this == GERMAN) return "Fröhliche Weihnachten wünscht dir"+ " " + greeterName + "!";
        else if(this == ENGLISH) return greeterName + " " + "wishes you a Merry Christmas!";
        else {
            return "Շնորհավոր Նոր Տարի" + " " + greeterName + "!";
        }
    }
}
