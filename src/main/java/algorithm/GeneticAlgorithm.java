package algorithm;

import model.Unit;

import java.util.*;

public class GeneticAlgorithm {

    /**
     * Рассичтываем коэфициент соотевтвия заданной последовательности (adaptation)
     * @param unit тестируемая последовательность
     * @param model модель, для которой рассчитывется оптимальный вариант оплаты (коэфициент соответсвия)
     */
    public static void fitness(Unit unit, List<Integer> model) {
        int adaptation = 0;
        List<Integer> coins = unit.getCoins();
        Iterator coinsIterator = coins.iterator();
        Iterator modelIterator = model.iterator();
        while (coinsIterator.hasNext() && modelIterator.hasNext()) {
            adaptation += Math.abs((Integer) coinsIterator.next() - (Integer) modelIterator.next());
        }
        unit.setAdaptation(adaptation);
    }

    /**
     * Случайным образом меняем один элемент в наборе для повышения шансов на успешный отбор
     * @param unit последовательность для изменения
     * @return возвращается мутировавшая последовательность
     */
    public static Unit mutate(Unit unit) {
        List<Integer> coinsList = unit.getCoins();
        int position1 = new Random().nextInt(8) + 1;
        int position2 = new Random().nextInt(8) + 1;
        Integer temp = coinsList.get(position1);
        coinsList.set(position1, coinsList.get(position2));
        coinsList.set(position2, temp);
        unit.setCoins(coinsList);
        return unit;
    }

    /**
     * Отбираем половину лучших предков, случайно генерируем новых членов популяции
     * @param parents предки
     * @return возвращаем новую популяцию
     */
    public static List<Unit> newGeneration(List<Unit> parents) {
        sortBest(parents);
        List<Unit> children = new LinkedList<Unit>();
        children.addAll(parents.subList(0, 5));
        for (int i = 0; i < 6; i++) {
            children.add(newUnit());
        }
        return children;
    }

    /**
     * Создание нового члена популяции
     * @return новая особь
     */
    public static Unit newUnit() {
        Unit unit = new Unit();
        unit.setCoins(generateRandom());
        return unit;
    }


    /**
     * Сортировка лучших особей
     * @param list популяция
     * @return отсортированная популяция
     */
    private static List<Unit> sortBest(List<Unit> list) {
        Collections.sort(list);
        return list;
    }

    /**
     * Генерация геномов случайным образом для новых ососбей
     * @return новый геном
     */
    public static List<Integer> generateRandom() {
        List<Integer> integerList = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            integerList.add(i);
        }
        Collections.shuffle(integerList);
        return integerList;
    }
}
