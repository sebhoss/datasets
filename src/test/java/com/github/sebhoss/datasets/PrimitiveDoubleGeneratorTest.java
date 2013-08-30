/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * Tests for the {@link PrimitiveDoubleGenerator}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class PrimitiveDoubleGeneratorTest {

    /**
     * Ensures that an array of doubles can be created.
     */
    @Test
    public void shouldGenerateDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles();

        // When
        final double[] doubles = generator.build();

        // Then
        Assert.assertNotNull(doubles);
    }

    /**
     * Ensures that an array of positive doubles can be created.
     */
    @Test
    public void shouldGeneratePositiveDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().lowestInclusive(0);

        // When
        final double[] doubles = generator.build();

        // Then
        Assert.assertNotNull(doubles);
    }

    /**
     * Ensures that an array of negative doubles can be created.
     */
    @Test
    public void shouldGenerateNegativeDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().highestInclusive(0);

        // When
        final double[] doubles = generator.build();

        // Then
        Assert.assertNotNull(doubles);
    }

    /**
     * Ensures that an array with a certain amount of doubles can be created.
     */
    @Test
    public void shouldGenerateCertainNumberOfDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().numbersToCreate(10);

        // When
        final double[] doubles = generator.build();

        // Then
        Assert.assertEquals(10, doubles.length);
    }

    /**
     * Ensures that the default amount of generated doubles is 100.
     */
    @Test
    public void shouldGenerate100DoublesByDefault() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles();

        // When
        final double[] doubles = generator.build();

        // Then
        Assert.assertEquals(100, doubles.length);
    }

    /**
     * Ensures that only positive doubles are in the created array.
     */
    @Test
    public void shouldContainPositiveDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().lowestInclusive(0);

        // When
        final double[] doubles = generator.build();

        // Then
        for (final double i : doubles) {
            Assert.assertTrue(i >= 0);
        }
    }

    /**
     * Ensures that only negative doubles are in the created array.
     */
    @Test
    public void shouldContainNegativeDoubles() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().highestInclusive(0);

        // When
        final double[] doubles = generator.build();

        // Then
        for (final double i : doubles) {
            Assert.assertTrue(i <= 0);
        }
    }

    /**
     * Ensures that doubles are in the specified positive range.
     */
    @Test
    public void shouldContainDoublesInPositiveRange() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().lowestInclusive(0).highestInclusive(1250);

        // When
        final double[] doubles = generator.build();

        // Then
        for (final double i : doubles) {
            Assert.assertTrue(i >= 0 && i <= 1250);
        }
    }

    /**
     * Ensures that doubles are in the specified negative range.
     */
    @Test
    public void shouldContainDoublesInNegativeRange() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().lowestInclusive(-5000).highestInclusive(-1);

        // When
        final double[] doubles = generator.build();

        // Then
        for (final double i : doubles) {
            Assert.assertTrue(i >= -5000 && i <= -1);
        }
    }

    /**
     * Ensures that doubles are in the specified range.
     */
    @Test
    public void shouldContainDoublesInRange() {
        // Given
        final PrimitiveDoubleGenerator generator = Datasets.doubles().lowestInclusive(-5000).highestInclusive(5000);

        // When
        final double[] doubles = generator.build();

        // Then
        for (final double i : doubles) {
            Assert.assertTrue(i >= -5000 && i <= 5000);
        }
    }

}
