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

        while (!adventuins.isEmpty())
        {
            Adventuin adventuin = adventuins.remove(adventuins.size() - 1);
            switch (adventuin.getHatType())
            {
                case SANTA_CLAUS: santa.add(adventuin);
                case FISHY_HAT: fishy.add(adventuin);
                case REINDEER: reindeer.add(adventuin);
                case NO_HAT: nohat.add(adventuin);
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
        adventuins.forEach(adventuin -> {System.out.println(adventuin.getLanguage().getLocalizedChristmasGreeting(adventuin.getName()));});
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
        return new HashMap<>();
    }
    public static void main(String[] args) {
        HatType hat  =  HatType.FISHY_HAT;
        Language lan = Language.GERMAN;
        RgbColor col = new RgbColor(8,255,255,255);
        Adventuin a = new Adventuin("beq",27,col,hat,lan);
        List<Adventuin> a1 = new ArrayList<Adventuin>();
        a1.add(a);
        a1.add(a);
        AdventuinParty party = new AdventuinParty();
        Map<HatType,List<Adventuin>> m = party.groupByHatType(a1);
        System.out.println(m.get(HatType.FISHY_HAT).size());


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
