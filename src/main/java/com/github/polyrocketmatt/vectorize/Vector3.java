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
     * Adds the given vector components to this vector.
     *
     * @param x The x component to add.
     * @param y The y component to add.
     * @param z The z component to add.
     * @return A new vector with the given components added.
     */
    public abstract Vector3<T> add(T x, T y, T z);

    /**
     * Subtracts the given vector components from this vector.
     *
     * @param x The x component to subtract.
     * @param y The y component to subtract.
     * @param z The z component to subtract.
     * @return A new vector with the given components subtracted.
     */
    public abstract Vector3<T> subtract(T x, T y, T z);

    /**
     * Multiplies the given vector components to this vector.
     *
     * @param x The x component to multiply.
     * @param y The y component to multiply.
     * @param z The z component to multiply.
     * @return A new vector with the given components multiplied.
     */
    public abstract Vector3<T> multiply(T x, T y, T z);

    /**
     * Divides the given vector components from this vector.
     *
     * @param x The x component to divide.
     * @param y The y component to divide.
     * @param z The z component to divide.
     * @return A new vector with the given components divided.
     */
    public abstract Vector3<T> divide(T x, T y, T z);

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
