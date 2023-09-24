package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 2-dimensional vector of type T.
 *
 * @param <T> The type of the vector.
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public abstract class Vector2<T> implements Vector<T>, Swizzle2<T> {

    /**
     * Rotates the vector by the given angle in radians.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    public abstract @NotNull Vector<Double> rotate(double angle);

}
