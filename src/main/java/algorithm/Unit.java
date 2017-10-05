package algorithm;

import java.util.LinkedList;
import java.util.List;

public class Unit implements Comparable {
    private List<Integer> coins;
    int adaptation;

    public Unit() {
    }

    public Unit(List<Integer> coins) {
        this.coins = coins;
    }

    public int getAdaptation() {
        return adaptation;
    }

    public void setAdaptation(int adaptation) {
        this.adaptation = adaptation;
    }

    public List<Integer> getCoins() {
        List<Integer> integerList = new LinkedList<Integer>();
        integerList.addAll(coins);
        return integerList;
    }

    public void setCoins(List<Integer> coins) {
        this.coins = coins;
    }

    public int compareTo(Object o) {
        Unit u = (Unit) o;
        if (adaptation > u.getAdaptation()) {
            return 1;
        } else if (adaptation < u.getAdaptation()) {
            return -1;
        }
        return 0;

    }
    public int getCoinByIndex(int index){
        return coins.get(index);
    }
}
