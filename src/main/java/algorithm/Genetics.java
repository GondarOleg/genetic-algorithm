package algorithm;

import java.util.*;

public class Genetics {

    List<Unit> population;
    Unit model;

    public Genetics() {
        population = new ArrayList<Unit>();
        for (int i = 0; i <= 10; i++) {
            Unit unit = new Unit();
            List<Integer> integerList = generateRandom();
            population.add(unit);
        }
    }

    public void setModel(Unit model) {
        this.model = model;
    }

    public List<Unit> select(List<Unit> population) {
        return null;
    }

    public void fitness(List<Unit> population) {
        for (Unit u : population
                ) {
            int adaptation = 0;
            for (int i = 0; i <= 10; i++) {
                adaptation +=
                        model.getCoins().get(i) > u.getCoins().get(i) ?
                                model.getCoins().get(i) - u.getCoins().get(i) :
                                u.getCoins().get(i) - model.getCoins().get(i);
            }
            u.setAdaptation(adaptation);
        }
    }

    public void mutate(Unit unit) {
        List<Integer> coinsList = unit.getCoins();
        coinsList.set(new Random().nextInt(9) + 1, new Random().nextInt(9));
    }

    public List<Unit> newGeneration() {
        List<Unit> parents = getBestOnes();
        List<Unit> childs = new ArrayList<Unit>();
        for (int i = 0; i < parents.size(); i++) {
            
        }
    }

    private List<Unit> getBestOnes() {
        Collections.sort(population);
        return population.subList(0, population.size() % 2 == 0 ? population.size() / 2 : population.size() / 2 + 1);
    }

    private List<Integer> generateRandom() {
        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 10) {
            generated.add(r.nextInt(9) + 1);
        }
        List<Integer> gen = new ArrayList<Integer>();
        gen.addAll(generated);
        return gen;
    }

    private void crossingover(Unit firstParent, Unit secondParent, Unit firstChild, Unit secondChild) {
        int crossPoint = new Random().nextInt(firstParent.getCoins().size() / 2);
        List<Integer> integerList = new ArrayList<Integer>();
        firstChild.setCoins(firstParent.getCoins().subList(0, crossPoint - 1));
        integerList = firstChild.getCoins();
        integerList.addAll(secondParent.getCoins().subList(crossPoint, secondParent.getCoins().size() - 1);
        firstChild.setCoins(integerList);
        secondChild.setCoins(secondParent.getCoins().subList(0, crossPoint - 1));
        integerList = secondChild.getCoins();
        integerList.addAll(firstParent.getCoins().subList(crossPoint, firstParent.getCoins().size() - 1));
        secondChild.setCoins(integerList);
    }
}