package pgdp.adventuin;
import java.util.*;
import pgdp.color.RgbColor;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public final class AdventuinParty {

    public static Map<HatType,List<Adventuin>> groupByHatType (List<Adventuin> adventuins)
    {
        List <Adventuin> santa = new ArrayList<>();
        List <Adventuin> reindeer = new ArrayList<>();
        List <Adventuin> fishy = new ArrayList<>();
        List <Adventuin> nohat = new ArrayList<>();

        List <Adventuin> adventuins1= adventuins.subList(0,adventuins.size() - 1);
        while (!adventuins1.isEmpty())
        {
            Adventuin adventuin = adventuins1.remove(adventuins1.size() - 1);
            switch (adventuin.getHatType())
            {
                case SANTA_CLAUS : {santa.add(adventuin);break;}
                case FISHY_HAT : {fishy.add(adventuin);break;}
                case REINDEER : {reindeer.add(adventuin);break;}
                case NO_HAT : {nohat.add(adventuin);break;}
            }


        }
        Map<HatType,List<Adventuin>> ans  = new HashMap<>();
        ans.put(HatType.FISHY_HAT, fishy);
        ans.put(HatType.NO_HAT, nohat);
        ans.put(HatType.REINDEER, reindeer);
        ans.put(HatType.SANTA_CLAUS,santa);
        return ans;

    }
    public static void printLocalizedChristmasGreetings (List<Adventuin> adventuins)
    {
        adventuins.stream().sorted(Comparator.comparingInt(Adventuin::getHeight)).forEach(adventuin -> {System.out.println(adventuin.getLanguage().getLocalizedChristmasGreeting(adventuin.getName()));});
    }
    public static Map<HatType, List<Adventuin>> getAdventuinsWithLongestNamesByHatType (List<Adventuin> adventuins)
    {
        Map<HatType,List<Adventuin>> ans = new HashMap<>();
        ans.put(HatType.FISHY_HAT,adventuins.stream().filter(adventuin -> adventuin.getHatType() == HatType.FISHY_HAT).max(Comparator.comparingInt(p -> p.getName().length())).stream().toList());
        ans.put(HatType.SANTA_CLAUS,adventuins.stream().filter(adventuin -> adventuin.getHatType() == HatType.SANTA_CLAUS).max(Comparator.comparingInt(p -> p.getName().length())).stream().toList());
        ans.put(HatType.NO_HAT,adventuins.stream().filter(adventuin -> adventuin.getHatType() == HatType.NO_HAT).max(Comparator.comparingInt(p -> p.getName().length())).stream().toList());
        ans.put(HatType.REINDEER,adventuins.stream().filter(adventuin -> adventuin.getHatType() == HatType.REINDEER).max(Comparator.comparingInt(p -> p.getName().length())).stream().toList());
        return ans;
    }
    public static   Map<Integer, Double> getAverageColorBrightnessByHeight (List<Adventuin> adventuins)
    {
        Map<Integer,Double> ans = new HashMap<>();
        adventuins.forEach(adventuin -> {
            Integer h = new AdventuinParty().round(adventuin.getHeight());
            ans.put(h, ((adventuin.getColor().getRed()*0.2126+adventuin.getColor().getGreen()*0.7152+adventuin.getColor().getBlue()*0.0722)/255));
        });
        return ans;
    }
    public Integer round (Integer i)
    {
        if(i%10>=5) return i-i%10+10;
        else return i-i%10;
    }
    public static Map<HatType, Double> getDiffOfAvgHeightDiffsToPredecessorByHatType (List<Adventuin> adventuins)
    {
        return new HashMap<>();
    }
    public static void main(String[] args) {
        HatType hat  =  HatType.FISHY_HAT;
        Language lan = Language.GERMAN;
        RgbColor col = new RgbColor(8,255,255,255);
        Adventuin a = new Adventuin("beq",27,col,hat,lan);
        Adventuin aa = new Adventuin("beqa",27,col,hat,Language.ENGLISH);
        List<Adventuin> a1 = new ArrayList<Adventuin>();
        a1.add(a);
        a1.add(aa);
        System.out.println(a1.size());
        AdventuinParty party = new AdventuinParty();
        party.printLocalizedChristmasGreetings(a1);
        Map<HatType,List<Adventuin>> m = party.groupByHatType(a1);
        System.out.println(m.get(HatType.FISHY_HAT).size());
        Map<HatType,List<Adventuin>> m1 = party.getAdventuinsWithLongestNamesByHatType(a1);



    }
 //   @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            @Override
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            @Override
//            public List<Adventuin> get(Object key) {
//                return null;
//            }
//
//            @Override
//            public List<Adventuin> put(HatType key, List<Adventuin> value) {
//                return null;
//            }
//
//            @Override
//            public List<Adventuin> remove(Object key) {
//                return null;
//            }
//
//            @Override
//            public void putAll(Map<? extends HatType, ? extends List<Adventuin>> m) {
//
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public Set<HatType> keySet() {
//                return null;
//            }
//
//            @Override
//            public Collection<List<Adventuin>> values() {
//                return null;
//            }
//
//            @Override
//            public Set<Entry<HatType, List<Adventuin>>> entrySet() {
//                return null;
//            }

}
