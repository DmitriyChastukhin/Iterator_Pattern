package main.java;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Минимальное число больше максимального");
        }
        this.random = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator();
    }

    private class IntegerIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            int diff = max - min;
            int result = random.nextInt(diff + 1) + min;
            return result;
        }
    }
}
