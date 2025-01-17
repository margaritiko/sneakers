package com.common.random;

import java.util.Random;
import javax.inject.Inject;

public class RandomService {

    private Random random;

    @Inject
    public RandomService() {
        random = new Random();
    }

    public int getRandomInt() {
        return Math.abs(random.nextInt());
    }

    public int getRandomInt(int left, int right) {
        return random.nextInt(right - left) + left;
    }

    public char getRandomCharacter() {
        return (char)(random.nextInt(26) + 'A');
    }
}
