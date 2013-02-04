/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details. */
package com.github.sebhoss.datasets;

import java.util.Random;

/**
 * TODO: document
 */
public class PrimitiveIntegerGenerator {

    private int    numbersToCreate;
    private Random numberGenerator;
    private long   highestInclusive;
    private long   lowestInclusive;

    PrimitiveIntegerGenerator() {
        this.numbersToCreate = 100;
        this.numberGenerator = new Random();
        this.highestInclusive = Integer.MAX_VALUE;
        this.lowestInclusive = Integer.MIN_VALUE;
    }

    /**
     * @param numbers
     *            The numbers to create.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator numbersToCreate(final int numbers) {
        this.numbersToCreate = numbers;

        return this;
    }

    /**
     * @param seed
     *            The random number generator seed.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator seed(final int seed) {
        this.numberGenerator = new Random(seed);

        return this;
    }

    /**
     * @param highest
     *            The highest number to generate.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator highestInclusive(final int highest) {
        this.highestInclusive = highest;

        return this;
    }

    /**
     * @param lowest
     *            The lowest number to generate.
     * @return The current generator.
     */
    public PrimitiveIntegerGenerator lowestInclusive(final int lowest) {
        this.lowestInclusive = lowest;

        return this;
    }

    /**
     * @return A new array of ints.
     */
    public int[] build() {
        final int[] array = new int[this.numbersToCreate];

        for (int index = 0; index < this.numbersToCreate; index++) {
            array[index] = this.createNextRandomNumber();
        }

        return array;
    }

    private int createNextRandomNumber() {
        final long range = this.highestInclusive - this.lowestInclusive;
        final double scaled = this.numberGenerator.nextDouble() * range;
        final double shifted = scaled + this.lowestInclusive;
        return (int) shifted;
    }

}
