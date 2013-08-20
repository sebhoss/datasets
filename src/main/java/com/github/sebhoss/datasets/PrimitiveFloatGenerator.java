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
 * Generator for primitive floats.
 */
public final class PrimitiveFloatGenerator {

    private int    numbersToCreate;
    private Random numberGenerator;
    private long   highestInclusive;
    private long   lowestInclusive;

    PrimitiveFloatGenerator() {
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
    public PrimitiveFloatGenerator numbersToCreate(final int numbers) {
        numbersToCreate = numbers;

        return this;
    }

    /**
     * @param seed
     *            The random number generator seed.
     * @return The current generator.
     */
    public PrimitiveFloatGenerator seed(final int seed) {
        numberGenerator = new Random(seed);

        return this;
    }

    /**
     * @param highest
     *            The highest number to generate.
     * @return The current generator.
     */
    public PrimitiveFloatGenerator highestInclusive(final int highest) {
        highestInclusive = highest;

        return this;
    }

    /**
     * @param lowest
     *            The lowest number to generate.
     * @return The current generator.
     */
    public PrimitiveFloatGenerator lowestInclusive(final int lowest) {
        lowestInclusive = lowest;

        return this;
    }

    /**
     * @return A new array of floats.
     */
    public float[] build() {
        final float[] array = new float[numbersToCreate];

        for (int index = 0; index < numbersToCreate; index++) {
            array[index] = createNextRandomNumber();
        }

        return array;
    }

    private float createNextRandomNumber() {
        final long range = highestInclusive - lowestInclusive;
        final double scaled = numberGenerator.nextDouble() * range;
        final double shifted = scaled + lowestInclusive;
        return (float) shifted;
    }

}
