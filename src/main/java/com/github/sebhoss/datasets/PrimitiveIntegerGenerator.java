/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

import java.util.Random;

/**
 * Generator for primitive integers.
 */
public final class PrimitiveIntegerGenerator {

    private int    numbersToCreate;
    private Random numberGenerator;
    private long   highestInclusive;
    private long   lowestInclusive;

    PrimitiveIntegerGenerator() {
        numbersToCreate = 100;
        numberGenerator = new Random();
        highestInclusive = Integer.MAX_VALUE;
        lowestInclusive = Integer.MIN_VALUE;
    }

    /**
     * @param numbers
     *            The numbers to create.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator numbersToCreate(final int numbers) {
        numbersToCreate = numbers;

        return this;
    }

    /**
     * @param seed
     *            The random number generator seed.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator seed(final int seed) {
        numberGenerator = new Random(seed);

        return this;
    }

    /**
     * @param highest
     *            The highest number to generate.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator highestInclusive(final int highest) {
        highestInclusive = highest;

        return this;
    }

    /**
     * @param lowest
     *            The lowest number to generate.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator lowestInclusive(final int lowest) {
        lowestInclusive = lowest;

        return this;
    }

    /**
     * @return A new array of ints.
     */
    public int[] build() {
        final int[] array = new int[numbersToCreate];

        for (int index = 0; index < numbersToCreate; index++) {
            array[index] = createNextRandomNumber();
        }

        return array;
    }

    private int createNextRandomNumber() {
        final long range = highestInclusive - lowestInclusive;
        final double scaled = numberGenerator.nextDouble() * range;
        final double shifted = scaled + lowestInclusive;
        return (int) shifted;
    }

}
