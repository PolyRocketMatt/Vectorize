package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 3-dimensional vector of type T.
 *
 * @param <T> The type of the vector.
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public abstract class Vector3<T> implements Vector<T>, Swizzle3<T> {

    /**
     * Calculate the cross product of this vector and another vector.
     *
     * @param other The other vector.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return A new vector representing the cross product of this vector and the other vector.
     */
    public abstract @NotNull Vector<T> cross(@NotNull Vector<T> other);

    /**
     * Rotates the vector by the given angle in radians around the X axis.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    public abstract @NotNull Double3 rotateX(double angle);

    /**
     * Rotates the vector by the given angle in radians around the Y axis.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    public abstract @NotNull Double3 rotateY(double angle);

    /**
     * Rotates the vector by the given angle in radians around the Z axis.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    public abstract @NotNull Double3 rotateZ(double angle);

}
