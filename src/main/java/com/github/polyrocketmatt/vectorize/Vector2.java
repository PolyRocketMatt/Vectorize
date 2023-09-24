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
     * Adds the given vector components to this vector.
     *
     * @param x The x component to add.
     * @param y The y component to add.
     * @return A new vector with the given components added.
     */
    public abstract Vector2<T> add(T x, T y);

    /**
     * Subtracts the given vector components from this vector.
     *
     * @param x The x component to subtract.
     * @param y The y component to subtract.
     * @return A new vector with the given components subtracted.
     */
    public abstract Vector2<T> subtract(T x, T y);

    /**
     * Multiplies the given vector components to this vector.
     *
     * @param x The x component to multiply.
     * @param y The y component to multiply.
     * @return A new vector with the given components multiplied.
     */
    public abstract Vector2<T> multiply(T x, T y);

    /**
     * Divides the given vector components from this vector.
     *
     * @param x The x component to divide.
     * @param y The y component to divide.
     * @return A new vector with the given components divided.
     */
    public abstract Vector2<T> divide(T x, T y);

    /**
     * Rotates the vector by the given angle in radians.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    public abstract @NotNull Vector<Double> rotate(double angle);

}
