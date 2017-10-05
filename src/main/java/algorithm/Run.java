package algorithm;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        List<Unit> population = new LinkedList<Unit>();
        List<Integer> model = new LinkedList<Integer>();
        Unit bestResult = new Unit();
        bestResult.setAdaptation(55);

        System.out.println("Enter 10 numbers:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++){
            model.add(i);
        }
        while (bestResult.getAdaptation() !=0){

            for (Unit u : population
                    ) {
                geneticAlgorithm.fitness(u, model);
                System.out.println("Adaptation = " + u.getAdaptation());
                if (bestResult.getAdaptation() >  u.getAdaptation()) {
                    bestResult = u;
                }
            }
            if(bestResult.getAdaptation() != 0) {
//                List<Unit> newGen = geneticAlgorithm.newGeneration(population.subList(0, population.size()/2));
//                population = new LinkedList<Unit>();
//                population = newGen;
                population = geneticAlgorithm.newGeneration(population);

                geneticAlgorithm.mutate(population.get(new Random().nextInt(8)+1));
                Collections.shuffle(population.get(new Random().nextInt(8)+1).getCoins());
            }
        }
        for (Integer i: bestResult.getCoins()
             ) {
            System.out.println(i);
        }
    }
}
