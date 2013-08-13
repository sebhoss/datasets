/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
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

    private Datasets() {
        // Factory class
    }

}
