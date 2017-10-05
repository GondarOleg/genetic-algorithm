package algorithm;

import java.util.*;

public class GeneticAlgorithm {

    public void fitness(Unit unit, List<Integer> model){
        int adaptation = 0;
        List<Integer> coins = unit.getCoins();
        Iterator coinsIterator = coins.iterator();
        Iterator modelIterator = model.iterator();
        while (coinsIterator.hasNext() && modelIterator.hasNext()){
            adaptation += Math.abs((Integer) coinsIterator.next() - (Integer) modelIterator.next());
        }
        unit.setAdaptation(adaptation);
    }

    public Unit mutate(Unit unit) {
        List<Integer> coinsList = unit.getCoins();
        int position1 = new Random().nextInt(8) + 1;
        int position2 = new Random().nextInt(8) + 1;
        Integer temp = coinsList.get(position1);
        coinsList.set(position1, coinsList.get(position2));
        coinsList.set(position2, temp);
        unit.setCoins(coinsList);
        return unit;
    }

    public List<Unit> newGeneration(List<Unit> parents){
        sortBest(parents);
        System.out.println(parents.size());
        List<Unit> children = new LinkedList<Unit>();
//        for (int i = 0; i<(parents.size()-1)/2;i++){
//            int count = 0;
//            for (int j = parents.size() - 1;  j> (parents.size()-1)/2; j--){
//                Random r = new Random();
//                int crossPoint = r.nextInt(9) + 1;
//                List<Integer> firstPartFirstParent = parents.get(i).getCoins().subList(0, crossPoint);
//                List<Integer> secondPartFirstParent = parents.get(i).getCoins().subList(crossPoint, parents.get(i).getCoins().size());
//                List<Integer> firstPartSecondParent = parents.get(j).getCoins().subList(0, crossPoint);
//                List<Integer> secondPartSecondParent = parents.get(j).getCoins().subList(crossPoint, parents.get(j).getCoins().size());
//                Unit firstChild = new Unit();
//                Unit secondChild = new Unit();
//                firstPartFirstParent.addAll(secondPartSecondParent);
//                firstPartSecondParent.addAll(secondPartFirstParent);
//                firstChild.setCoins(firstPartFirstParent);
//                secondChild.setCoins(firstPartSecondParent);
//                children.add(firstChild);
//                children.add(secondChild);
//            }
//
//        }
//        parents.clear();
        children.addAll(parents.subList(0, 5));
        for (int i = 0; i < 6; i++){
            children.add(newUnit());
        }
        return children;
    }

    public Unit newUnit(){
            Unit unit = new Unit();
            unit.setCoins(this.generateRandom());
            return unit;
    }


    private List<Unit> sortBest(List<Unit> list){
        Collections.sort(list);
        return list;
    }

    public List<Integer> generateRandom() {
        List<Integer> integerList = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++){
            integerList.add(i);
        }
        Collections.shuffle(integerList);
        return integerList;
    }
}
