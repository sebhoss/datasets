/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.warnings.CompilerWarnings;

/**
 * Tests for the {@link PrimitiveLongGenerator}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class PrimitiveLongGeneratorTest {

    /**
     * Ensures that an array of longs can be created.
     */
    @Test
    public void shouldGenerateLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs();

        // When
        final long[] longs = generator.build();

        // Then
        Assert.assertNotNull(longs);
    }

    /**
     * Ensures that an array of positive longs can be created.
     */
    @Test
    public void shouldGeneratePositiveLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().lowestInclusive(0);

        // When
        final long[] longs = generator.build();

        // Then
        Assert.assertNotNull(longs);
    }

    /**
     * Ensures that an array of negative longs can be created.
     */
    @Test
    public void shouldGenerateNegativeLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().highestInclusive(0);

        // When
        final long[] longs = generator.build();

        // Then
        Assert.assertNotNull(longs);
    }

    /**
     * Ensures that an array with a certain amount of longs can be created.
     */
    @Test
    public void shouldGenerateCertainNumberOfLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().numbersToCreate(10);

        // When
        final long[] longs = generator.build();

        // Then
        Assert.assertEquals(10, longs.length);
    }

    /**
     * Ensures that the default amount of generated longs is 100.
     */
    @Test
    public void shouldGenerate100LongsByDefault() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs();

        // When
        final long[] longs = generator.build();

        // Then
        Assert.assertEquals(100, longs.length);
    }

    /**
     * Ensures that only positive longs are in the created array.
     */
    @Test
    public void shouldContainPositiveLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().lowestInclusive(0);

        // When
        final long[] longs = generator.build();

        // Then
        for (final long i : longs) {
            Assert.assertTrue(i >= 0);
        }
    }

    /**
     * Ensures that only negative longs are in the created array.
     */
    @Test
    public void shouldContainNegativeLongs() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().highestInclusive(0);

        // When
        final long[] longs = generator.build();

        // Then
        for (final long i : longs) {
            Assert.assertTrue(i <= 0);
        }
    }

    /**
     * Ensures that longs are in the specified positive range.
     */
    @Test
    public void shouldContainLongsInPositiveRange() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().lowestInclusive(0).highestInclusive(1250);

        // When
        final long[] longs = generator.build();

        // Then
        for (final long i : longs) {
            Assert.assertTrue(i >= 0 && i <= 1250);
        }
    }

    /**
     * Ensures that longs are in the specified negative range.
     */
    @Test
    public void shouldContainLongsInNegativeRange() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().lowestInclusive(-5000).highestInclusive(-1);

        // When
        final long[] longs = generator.build();

        // Then
        for (final long i : longs) {
            Assert.assertTrue(i >= -5000 && i <= -1);
        }
    }

    /**
     * Ensures that longs are in the specified range.
     */
    @Test
    public void shouldContainLongsInRange() {
        // Given
        final PrimitiveLongGenerator generator = Datasets.longs().lowestInclusive(-5000).highestInclusive(5000);

        // When
        final long[] longs = generator.build();

        // Then
        for (final long i : longs) {
            Assert.assertTrue(i >= -5000 && i <= 5000);
        }
    }

}
