//package pgdp.adventuin;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public final class AdventuinParty {
//
//    public static Map<HatType,List<Adventuin>> groupByHatType (List<Adventuin> adventuins)
//    {
//        Map<HatType,List<Adventuin>> ans  = null;
//        List <Adventuin> santa = null;
//        List <Adventuin> reindeer = null;
//        List <Adventuin> fishy = null;
//        List <Adventuin> nohat = null;
//        List <Adventuin> adventuins1 = null;
//        while (!adventuins.isEmpty())
//        {
//            Adventuin adventuin = adventuins.remove(adventuins.size() - 1);
//            switch (adventuin.getHatType())
//            {
//               case  SANTA_CLAUS: santa.add(adventuin);
//                case FISHY_HAT: fishy.add(adventuin);
//                case REINDEER: reindeer.add(adventuin);
//                case NO_HAT: nohat.add(adventuin);
//            }
//            adventuins1.add(adventuin);
//        }
//        ans.put(HatType.FISHY_HAT, fishy);
//        ans.put(HatType.NO_HAT, nohat);
//        ans.put(HatType.REINDEER, reindeer);
//        ans.put(HatType.SANTA_CLAUS,santa);
//        return ans;
//    }
// //   @Override
////            public int size() {
////                return 0;
////            }
////
////            @Override
////            public boolean isEmpty() {
////                return false;
////            }
////
////            @Override
////            public boolean containsKey(Object key) {
////                return false;
////            }
////
////            @Override
////            public boolean containsValue(Object value) {
////                return false;
////            }
////
////            @Override
////            public List<Adventuin> get(Object key) {
////                return null;
////            }
////
////            @Override
////            public List<Adventuin> put(HatType key, List<Adventuin> value) {
////                return null;
////            }
////
////            @Override
////            public List<Adventuin> remove(Object key) {
////                return null;
////            }
////
////            @Override
////            public void putAll(Map<? extends HatType, ? extends List<Adventuin>> m) {
////
////            }
////
////            @Override
////            public void clear() {
////
////            }
////
////            @Override
////            public Set<HatType> keySet() {
////                return null;
////            }
////
////            @Override
////            public Collection<List<Adventuin>> values() {
////                return null;
////            }
////
////            @Override
////            public Set<Entry<HatType, List<Adventuin>>> entrySet() {
////                return null;
////            }
//
//}
