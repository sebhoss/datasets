/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.datasets;

/**
 * Factory for common datasets.
 */
public final class Datasets {

    /**
     * @return A new generator for integers.
     */
    public static PrimitiveIntegerGenerator ints() {
        return new PrimitiveIntegerGenerator();
    }

    /**
     * @return A new generator for longs.
     */
    public static PrimitiveLongGenerator longs() {
        return new PrimitiveLongGenerator();
    }

    /**
     * @return A new generator for doubles.
     */
    public static PrimitiveDoubleGenerator doubles() {
        return new PrimitiveDoubleGenerator();
    }

    /**
     * @return A new generator for floats.
     */
    public static PrimitiveFloatGenerator floats() {
        return new PrimitiveFloatGenerator();
    }

    private Datasets() {
        // Factory class
    }

}
