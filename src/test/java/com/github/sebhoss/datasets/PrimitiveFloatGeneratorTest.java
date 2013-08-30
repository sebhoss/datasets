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
 * Tests for the {@link PrimitiveFloatGenerator}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class PrimitiveFloatGeneratorTest {

    /**
     * Ensures that an array of floats can be created.
     */
    @Test
    public void shouldGenerateFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats();

        // When
        final float[] floats = generator.build();

        // Then
        Assert.assertNotNull(floats);
    }

    /**
     * Ensures that an array of positive floats can be created.
     */
    @Test
    public void shouldGeneratePositiveFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().lowestInclusive(0);

        // When
        final float[] floats = generator.build();

        // Then
        Assert.assertNotNull(floats);
    }

    /**
     * Ensures that an array of negative floats can be created.
     */
    @Test
    public void shouldGenerateNegativeFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().highestInclusive(0);

        // When
        final float[] floats = generator.build();

        // Then
        Assert.assertNotNull(floats);
    }

    /**
     * Ensures that an array with a certain amount of floats can be created.
     */
    @Test
    public void shouldGenerateCertainNumberOfFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().numbersToCreate(10);

        // When
        final float[] floats = generator.build();

        // Then
        Assert.assertEquals(10, floats.length);
    }

    /**
     * Ensures that the default amount of generated floats is 100.
     */
    @Test
    public void shouldGenerate100FloatsByDefault() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats();

        // When
        final float[] floats = generator.build();

        // Then
        Assert.assertEquals(100, floats.length);
    }

    /**
     * Ensures that only positive floats are in the created array.
     */
    @Test
    public void shouldContainPositiveFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().lowestInclusive(0);

        // When
        final float[] floats = generator.build();

        // Then
        for (final float i : floats) {
            Assert.assertTrue(i >= 0);
        }
    }

    /**
     * Ensures that only negative floats are in the created array.
     */
    @Test
    public void shouldContainNegativeFloats() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().highestInclusive(0);

        // When
        final float[] floats = generator.build();

        // Then
        for (final float i : floats) {
            Assert.assertTrue(i <= 0);
        }
    }

    /**
     * Ensures that floats are in the specified positive range.
     */
    @Test
    public void shouldContainFloatsInPositiveRange() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().lowestInclusive(0).highestInclusive(1250);

        // When
        final float[] floats = generator.build();

        // Then
        for (final float i : floats) {
            Assert.assertTrue(i >= 0 && i <= 1250);
        }
    }

    /**
     * Ensures that floats are in the specified negative range.
     */
    @Test
    public void shouldContainFloatsInNegativeRange() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().lowestInclusive(-5000).highestInclusive(-1);

        // When
        final float[] floats = generator.build();

        // Then
        for (final float i : floats) {
            Assert.assertTrue(i >= -5000 && i <= -1);
        }
    }

    /**
     * Ensures that floats are in the specified range.
     */
    @Test
    public void shouldContainFloatsInRange() {
        // Given
        final PrimitiveFloatGenerator generator = Datasets.floats().lowestInclusive(-5000).highestInclusive(5000);

        // When
        final float[] floats = generator.build();

        // Then
        for (final float i : floats) {
            Assert.assertTrue(i >= -5000 && i <= 5000);
        }
    }

}
