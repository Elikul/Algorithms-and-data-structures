import java.util.ArrayList;
import java.util.List;

/**
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */
public class Backpack {

    /**
     * класс Вещи
     */
    static class Goods{
        protected int count; //количество
        protected double weight; //вес
        protected String name; //название

        public Goods(int _count, double _weight, String _name){
            this.count = _count;
            this.weight = _weight;
            this.name = _name;
        }

    }

    /**
     * класс Рюкзак
     */
    static class Bag{
        private List<Goods> bestStuff = null; //вещи, которые поместяться в рюкзак
        private double maxWeight; //максимальный вес рюкзака
        private double bestPrice; //количество вещей, которое поместиться в рюкзак

        public Bag(double _maxWeight){
            this.maxWeight = _maxWeight;
        }


        //вычисляем общий вес набора предметов
        private double countWeight(List<Goods> goods){
            double sumW = 0;

            for (Goods item : goods) {
                sumW += item.weight;

            }
            return sumW;
        }

        //вычисляем общее количество предметов
        private double countPrice(List<Goods> goods){
            double sumPrice = 0;

            for (Goods item : goods) {
                sumPrice += item.count;
            }
            return sumPrice;
        }

        //проверка, является ли данный набор лучшим решением задачи
        private void checkSet(List<Goods> goods){
            if(bestStuff == null){
                if(countWeight(goods) <= maxWeight){
                    bestStuff = goods;
                    bestPrice = countPrice(goods);
                }
            }else{
                if((countWeight(goods) <= maxWeight) && countPrice(goods) > bestPrice){
                    bestStuff = goods;
                    bestPrice = countPrice(goods);
                }
            }
        }

        //все наборы предметов в рюкзак,которые возможны
        public void allSets(List<Goods> goods){
            if(goods.size() > 0){
                checkSet(goods);
            }

                for(int i = 0; i < goods.size(); i++){
                    List<Goods> newSet = new ArrayList<>(goods);
                    newSet.remove(i);
                    allSets(newSet);
                }
        }

        public String toString(){
            return "Bag: weight - " + maxWeight + ", bestPrice - " + bestPrice + "\n";
        }

        //возращаем лучший набор предметов в рюкзак
        public List<Goods> getBestStuff(){
            return bestStuff;
        }

    }

    public static void main(String[] args) {

        List<Goods> stuff = new ArrayList<>(); //предметы,которые имеются

        stuff.add(new Goods(1, 600, "book"));
        stuff.add(new Goods(2, 300, "glass"));
        stuff.add(new Goods(4, 1500, "bottle"));
        stuff.add(new Goods(2, 40000, "laptop"));
        stuff.add(new Goods(1, 500, "bowl"));

        Bag bp = new Bag(3000);
        bp.allSets(stuff);

        List<Goods> bestBag = bp.getBestStuff(); //предметы,которые уместяться в рюкзаке
        System.out.println(bp.toString());
        for( Goods item : bestBag){
            System.out.println(item.name + " количество - " +  item.count +  " вес - "  + item.weight);
        }

    }
}
