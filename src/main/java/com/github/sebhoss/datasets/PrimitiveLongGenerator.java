/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

import java.util.Random;

/**
 * Generator for primitive longs.
 */
public class PrimitiveLongGenerator {

    private int    numbersToCreate;
    private Random numberGenerator;
    private long   highestInclusive;
    private long   lowestInclusive;

    PrimitiveLongGenerator() {
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
    public PrimitiveLongGenerator numbersToCreate(final int numbers) {
        numbersToCreate = numbers;

        return this;
    }

    /**
     * @param seed
     *            The random number generator seed.
     * @return The current generator.
     */
    public PrimitiveLongGenerator seed(final int seed) {
        numberGenerator = new Random(seed);

        return this;
    }

    /**
     * @param highest
     *            The highest number to generate.
     * @return The current generator.
     */
    public PrimitiveLongGenerator highestInclusive(final int highest) {
        highestInclusive = highest;

        return this;
    }

    /**
     * @param lowest
     *            The lowest number to generate.
     * @return The current generator.
     */
    public PrimitiveLongGenerator lowestInclusive(final int lowest) {
        lowestInclusive = lowest;

        return this;
    }

    /**
     * @return A new array of ints.
     */
    public long[] build() {
        final long[] array = new long[numbersToCreate];

        for (int index = 0; index < numbersToCreate; index++) {
            array[index] = createNextRandomNumber();
        }

        return array;
    }

    private long createNextRandomNumber() {
        final long range = highestInclusive - lowestInclusive;
        final double scaled = numberGenerator.nextDouble() * range;
        final double shifted = scaled + lowestInclusive;
        return (long) shifted;
    }

}
