package org.academiadecodigo.argicultores;

public class Random {
    private final int random;
    public Random(int num) {
        random = (int) (Math.floor(Math.random() * num));
    }
    public int getRandom() {
        return random;
    }
}
