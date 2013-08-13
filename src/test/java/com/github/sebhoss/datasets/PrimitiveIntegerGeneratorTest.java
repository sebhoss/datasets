/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * Tests for the {@link PrimitiveIntegerGenerator}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class PrimitiveIntegerGeneratorTest {

    /**
     * Ensures that an array of ints can be created.
     */
    @Test
    public void shouldGenerateInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints();

        // When
        final int[] ints = generator.build();

        // Then
        Assert.assertNotNull(ints);
    }

    /**
     * Ensures that an array of positive ints can be created.
     */
    @Test
    public void shouldGeneratePositiveInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().lowestInclusive(0);

        // When
        final int[] ints = generator.build();

        // Then
        Assert.assertNotNull(ints);
    }

    /**
     * Ensures that an array of negative ints can be created.
     */
    @Test
    public void shouldGenerateNegativeInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().highestInclusive(0);

        // When
        final int[] ints = generator.build();

        // Then
        Assert.assertNotNull(ints);
    }

    /**
     * Ensures that an array with a certain amount of ints can be created.
     */
    @Test
    public void shouldGenerateCertainNumberOfInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().numbersToCreate(10);

        // When
        final int[] ints = generator.build();

        // Then
        Assert.assertEquals(10, ints.length);
    }

    /**
     * Ensures that the default amount of generated ints is 100.
     */
    @Test
    public void shouldGenerate100IntsByDefault() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints();

        // When
        final int[] ints = generator.build();

        // Then
        Assert.assertEquals(100, ints.length);
    }

    /**
     * Ensures that only positive ints are in the created array.
     */
    @Test
    public void shouldContainPositiveInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().lowestInclusive(0);

        // When
        final int[] ints = generator.build();

        // Then
        for (final int i : ints) {
            Assert.assertTrue(i >= 0);
        }
    }

    /**
     * Ensures that only negative ints are in the created array.
     */
    @Test
    public void shouldContainNegativeInts() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().highestInclusive(0);

        // When
        final int[] ints = generator.build();

        // Then
        for (final int i : ints) {
            Assert.assertTrue(i <= 0);
        }
    }

    /**
     * Ensures that ints are in the specified positive range.
     */
    @Test
    public void shouldContainIntsInPositiveRange() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().lowestInclusive(0).highestInclusive(1250);

        // When
        final int[] ints = generator.build();

        // Then
        for (final int i : ints) {
            Assert.assertTrue(i >= 0 && i <= 1250);
        }
    }

    /**
     * Ensures that ints are in the specified negative range.
     */
    @Test
    public void shouldContainIntsInNegativeRange() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().lowestInclusive(-5000).highestInclusive(-1);

        // When
        final int[] ints = generator.build();

        // Then
        for (final int i : ints) {
            Assert.assertTrue(i >= -5000 && i <= -1);
        }
    }

    /**
     * Ensures that ints are in the specified range.
     */
    @Test
    public void shouldContainIntsInRange() {
        // Given
        final PrimitiveIntegerGenerator generator = Datasets.ints().lowestInclusive(-5000).highestInclusive(5000);

        // When
        final int[] ints = generator.build();

        // Then
        for (final int i : ints) {
            Assert.assertTrue(i >= -5000 && i <= 5000);
        }
    }

}
