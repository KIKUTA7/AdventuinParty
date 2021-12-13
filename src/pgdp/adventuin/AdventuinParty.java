package pgdp.adventuin;

import java.util.*;
import pgdp.color.ExceptionUtil;
import pgdp.color.RgbColor;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public final class AdventuinParty {

    public static Map<HatType,List<Adventuin>> groupByHatType (List<Adventuin> adventuins) {
        List<Adventuin> santa = new LinkedList<>();
        List<Adventuin> reindeer = new LinkedList<>();
        List<Adventuin> fishy = new LinkedList<>();
        List<Adventuin> nohat = new LinkedList<>();


        for (Adventuin adventuin : adventuins) {


            if (adventuin.getHatType() == HatType.FISHY_HAT) fishy.add(adventuin);
            else if (adventuin.getHatType() == HatType.SANTA_CLAUS) santa.add(adventuin);
            else if (adventuin.getHatType() == HatType.NO_HAT) nohat.add(adventuin);
            else reindeer.add(adventuin);


        }

        Map<HatType,List<Adventuin>> ans  = new HashMap<>();

        if(fishy.size()!=0) ans.put(HatType.FISHY_HAT, fishy);
        if(nohat.size()!=0) ans.put(HatType.NO_HAT, nohat);
        if(reindeer.size()!=0) ans.put(HatType.REINDEER, reindeer);
        if(santa.size()!=0) ans.put(HatType.SANTA_CLAUS,santa);
        return ans;

    }
    public static void printLocalizedChristmasGreetings (List<Adventuin> adventuins)
    {
        adventuins.stream().sorted(Comparator.comparingInt(Adventuin::getHeight)).forEach(adventuin -> {System.out.println(adventuin.getLanguage().getLocalizedChristmasGreeting(adventuin.getName()));});
    }
    public static Map<HatType, List<Adventuin>> getAdventuinsWithLongestNamesByHatType (List<Adventuin> adventuins)
    {
        Map <HatType,List<Adventuin>> map = new AdventuinParty().groupByHatType(adventuins);
        Map <HatType,List<Adventuin>> ans = new HashMap<>();
        groupByHatType(adventuins).entrySet().stream().forEach(adventuin -> {
           int Mx =  adventuin.getValue().stream().max(Comparator.comparingInt(x -> x.getName().length())).get().getName().length();
           ans.put(adventuin.getKey(), adventuin.getValue().stream().filter(adventuin1 -> adventuin1.getName().length()==Mx).collect(Collectors.toList()));
        });

        return ans;
    }
    public static   Map<Integer, Double> getAverageColorBrightnessByHeight (List<Adventuin> adventuins)
    {
        Map<Integer,Double> ans = new HashMap<>();
        Map<Integer,Integer> step = new HashMap<>();
        adventuins.forEach(adventuin -> {
            Integer h = round(adventuin.getHeight());
            if(ans.get(h) != null)
            ans.put(h, (ans.get(h)*step.get(h)
                    +(adventuin.getColor().toRgbColor8Bit().getRed()*0.2126+
                    adventuin.getColor().toRgbColor8Bit().getGreen()*0.7152+
                    adventuin.getColor().toRgbColor8Bit().getBlue()*0.0722)/255)/(step.get(h)+1));
            else
            {
                ans.put(h, ((adventuin.getColor().toRgbColor8Bit().getRed()*0.2126+
                        adventuin.getColor().toRgbColor8Bit().getGreen()*0.7152+
                        adventuin.getColor().toRgbColor8Bit().getBlue()*0.0722)/255));
            }
            if(step.get(h) == null) step.put(h,1);
            else step.put(h,step.get(h)+1);
        });
        return ans;
    }
    public static Integer round (Integer i)
    {
        return (i+5)/10*10;
    }
    public static Map<HatType, Double> getDiffOfAvgHeightDiffsToPredecessorByHatType (List<Adventuin> adventuins)
    {
          Map<HatType, Double> ans = new HashMap<>();
          groupByHatType(adventuins).forEach((key, value) -> {
              if (adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size() == 1)
                  ans.put(key, 0.0);
              else {
              double positiveSum = 0.0;
              int negativeQuantity = 0;
              double negativeSum = 0.0;
              int positiveQuantity = 0;

              for (int i = 1; i < adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size(); i++) {
                  if ((double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i).getHeight() <= 0.0) {
                      ExceptionUtil.unsupportedOperation("aba uyure");
                  }

                  if ( (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i).getHeight() -
                          (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i - 1).getHeight()
                          < 0.0) {
                      negativeSum +=   (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i).getHeight() -
                              (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i - 1).getHeight();
                      negativeQuantity++;
                  } else if (  (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i).getHeight() -
                          (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i - 1).getHeight()
                          > 0.0) {
                      positiveSum +=  (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i).getHeight() -
                              (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(i - 1).getHeight();
                      positiveQuantity++;
                  }

              }
              if ((double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(0).getHeight() <= 0.0) {
                  ExceptionUtil.unsupportedOperation("aba uyure");
              }
              if ((double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(0).getHeight()
                      - (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(
                      adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size() - 1).getHeight()
                      < 0.0
              ) {
                  negativeSum += (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(0).getHeight()
                          - (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(
                          adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size() - 1).getHeight();
                  negativeQuantity++;
              } else if ((double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(0).getHeight()
                      - (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(
                      adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size() - 1).getHeight()
                      > 0.0
              ) {
                  positiveSum += (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(0).getHeight()
                          - (double) adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().get(
                          adventuins.stream().filter(adventuin1 -> adventuin1.getHatType() == key).toList().size() - 1).getHeight();
                  positiveQuantity++;
              }
              double resultat = 0.0;
              if (negativeQuantity != 0) resultat += (-1.0) * (double) negativeSum / negativeQuantity;
              if (positiveQuantity != 0) resultat += (double) positiveSum / positiveQuantity;


              if(resultat >= 0.0)
                  ans.put(key, resultat);
              else ans.put(key,0.0);
              }
          });
        return ans;
    }
    public static void main(String[] args) {
//        HatType hat  =  HatType.FISHY_HAT;
//        Language lan = Language.GERMAN;
//        Language lan1 = Language.ARMENIAN;
//        RgbColor col = new RgbColor(8,255,255,255);
//        Adventuin a = new Adventuin("beqa",27,col,hat,lan);
//        Adventuin aa = new Adventuin("beqa",27,col,hat,Language.ENGLISH);
//        Adventuin b = new Adventuin("beq",27,col,hat,lan);
//        Adventuin bb = new Adventuin("beqa",27,col,hat,Language.ENGLISH);
//        Adventuin c = new Adventuin("beq",27,col,hat,lan);
//        Adventuin cc = new Adventuin("beqa",27,col,hat,Language.ENGLISH);
//        Adventuin d = new Adventuin("beq",10,col,hat,lan);
//        Adventuin dd = new Adventuin("beqa",5,col,hat,Language.ENGLISH);
//        Adventuin f = new Adventuin("beq",1,col,hat,lan);
//        Adventuin ff = new Adventuin("beqa",11,col,hat,Language.ENGLISH);
//        List<Adventuin> a1 = new ArrayList<Adventuin>();
//        List<Adventuin> a2 = new ArrayList<>();
//        a1.add(a);
//        a1.add(aa);
//
//        a1.add(b);
//        a1.add(bb);
//
//        a1.add(c);
//        a1.add(cc);
//
//        a1.add(d);
//        a1.add(dd);
//        a2.add(f);
//        a2.add(ff);
//        a2.add(dd);
//        a2.add(d);
//        AdventuinParty party = new AdventuinParty();
//        Map<HatType,Double> m = party.getDiffOfAvgHeightDiffsToPredecessorByHatType(a2);
//        System.out.println(m.get(HatType.FISHY_HAT));


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
