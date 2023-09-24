package com.github.polyrocketmatt.vectorize;

/**
 * Represents an immutable 4-dimensional vector of type T.
 *
 * @param <T> The type of the vector.
 * @author Matthias Kovacic
 * @since 1.0.2
 */
public abstract class Vector4<T> implements Vector<T> {

    /**
     * Adds the given vector components to this vector.
     *
     * @param x The x component to add.
     * @param y The y component to add.
     * @param z The z component to add.
     * @param w The w component to add.
     * @return A new vector with the given components added.
     */
    public abstract Vector4<T> add(T x, T y, T z, T w);

    /**
     * Subtracts the given vector components from this vector.
     *
     * @param x The x component to subtract.
     * @param y The y component to subtract.
     * @param z The z component to subtract.
     * @param w The w component to subtract.
     * @return A new vector with the given components subtracted.
     */
    public abstract Vector4<T> subtract(T x, T y, T z, T w);

    /**
     * Multiplies the given vector components to this vector.
     *
     * @param x The x component to multiply.
     * @param y The y component to multiply.
     * @param z The z component to multiply.
     * @param w The w component to multiply.
     * @return A new vector with the given components multiplied.
     */
    public abstract Vector4<T> multiply(T x, T y, T z, T w);

    /**
     * Divides the given vector components from this vector.
     *
     * @param x The x component to divide.
     * @param y The y component to divide.
     * @param z The z component to divide.
     * @param w The w component to divide.
     * @return A new vector with the given components divided.
     */
    public abstract Vector4<T> divide(T x, T y, T z, T w);

}
