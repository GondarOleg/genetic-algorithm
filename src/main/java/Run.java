

import algorithm.GeneticAlgorithm;
import model.Unit;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Для нахождения оптимального порядка платежей используем впомогательный класс GeneticAlgorithm.
 * С помощью этого класса проводим отбор лучших экземпляров, создание новых поколений, мутацию и тестирование их.
 */

public class Run {

    private final static int MAX_TIMES_OF_SELECTION = 115000;

    public static void main(String[] args) {
        showResults(performSearchWithGeneticAlgorithm(getUserInput()));
    }

    /**
     * Производим поиск наиболее удачного варианта оплаты. Если невозможно максимальное соответсвие (0),
     * то ищем наиболее удачный вариант 15000 раз.
     * Сначала создаётся эталонная модель и популяция со случайным набором.
     * Затем проводится её тестирование и, если не найден оптимум, генерируется новая популяция из половины лучших особей
     * и половины случайных новых, также проводится мутация одного случаного члена популяции.
     * Если не находится оптимум, селекция продолжается 15000 раз.
     * В результате выводится наиболее удачный результат естественного отбора.
     * @param userInput введенная пользователем последовательность цен на пунктах сбора денег
     * @return возвращаем оптимальный порядок оплаты монетами от 1 до 10 для введенной последовательности цен на пунктах оплаты
     */
    public static Unit performSearchWithGeneticAlgorithm(List<Integer> userInput) {
        Unit bestResult = new Unit();
        bestResult.setAdaptation(55);
        List<Unit> population = createInitialPopulation();
        int loopCount = 0;
        while (bestResult.getAdaptation() != 0 && loopCount < MAX_TIMES_OF_SELECTION) {
            for (Unit u : population
                    ) {
                GeneticAlgorithm.fitness(u, userInput);
                if (bestResult.getAdaptation() > u.getAdaptation()) {
                    bestResult = u;
                }
            }
            if (bestResult.getAdaptation() != 0) {
                population = GeneticAlgorithm.newGeneration(population);
                GeneticAlgorithm.mutate(population.get(new Random().nextInt(8) + 1));
                loopCount++;
            }
        }
        return bestResult;
    }

    public static List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> userInputList = new LinkedList<Integer>();
        System.out.println("Enter 10 numbers:");
        for (int i = 1; i <= 10; i++) {
            int userInput = scanner.nextInt();
            while (userInput > 10 || userInput == 0) {
                System.out.println("Value must be between 1 an 10! Enter again:");
                userInput = scanner.nextInt();
            }
            userInputList.add(userInput);
        }
        return userInputList;
    }

    public static List<Unit> createInitialPopulation() {
        List<Unit> population = new LinkedList<Unit>();
        for (int i = 0; i <= 12; i++) {
            population.add(GeneticAlgorithm.newUnit());
        }
        return population;
    }

    public static void showResults(Unit bestResult) {
        System.out.println("You must pay in the following order:");
        for (Integer i : bestResult.getCoins()
                ) {
            System.out.println(i + " coin");
        }
    }
}
