package algorithm;

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
        return coins;
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
}
