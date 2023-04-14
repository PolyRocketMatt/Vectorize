package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable vector of type T.
 *
 * @param <T> The type of the vector.
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public interface Vector<T> {

    /**
     * Add a vector to this vector.
     *
     * @param other The vector to add.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> add(@NotNull Vector<T> other) throws IllegalArgumentException;

    /**
     * Subtract a vector from this vector.
     *
     * @param other The vector to subtract.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> subtract(@NotNull Vector<T> other) throws IllegalArgumentException;

    /**
     * Multiply a vector with this vector.
     *
     * @param other The vector to multiply.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> multiply(@NotNull Vector<T> other) throws IllegalArgumentException;

    /**
     * Divide a vector by this vector.
     *
     * @param other The vector to divide.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @throws ArithmeticException If the divisor is zero.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> divide(@NotNull Vector<T> other) throws IllegalArgumentException;

    /**
     * Raise this vector to the power of another vector.
     *
     * @param other The vector to raise to the power of.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> pow(@NotNull Vector<T> other) throws IllegalArgumentException;

    /**
     * Add a scalar to this vector.
     *
     * @param scalar The scalar to add.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> add(@NotNull T scalar);

    /**
     * Subtract a scalar from this vector.
     *
     * @param scalar The scalar to subtract.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> subtract(@NotNull T scalar);

    /**
     * Multiply a scalar with this vector.
     *
     * @param scalar The scalar to multiply.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> multiply(@NotNull T scalar);

    /**
     * Divide a scalar by this vector.
     *
     * @param scalar The scalar to divide.
     * @throws ArithmeticException If the divisor is zero.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> divide(@NotNull T scalar);

    /**
     * Raise this vector to the power of a scalar.
     *
     * @param scalar The scalar to raise to the power of.
     * @return A new vector with the result.
     */
    @NotNull Vector<T> pow(@NotNull T scalar);

    /**
     * Negate this vector.
     *
     * @return A new vector with the negated values.
     */
    @NotNull Vector<T> negate();

    /**
     * Calculate the absolute value of this vector.
     *
     * @return A new vector with the absolute values.
     */
    @NotNull Vector<T> abs();

    /**
     * Normalize this vector.
     *
     * @return A new vector with the normalized values.
     */
    @NotNull Vector<Double> normalize();

    /**
     * Calculate the dot product of this vector and another vector.
     *
     * @param other The other vector.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return The dot product.
     */
    @NotNull T dot(@NotNull Vector<T> other);

    /**
     * Calculate the angle between this vector and another vector.
     *
     * @param other The other vector.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return The angle between the vectors.
     */
    @NotNull Double angle(@NotNull Vector<T> other);

    /**
     * Calculate the length of this vector.
     *
     * @return The length of this vector.
     */
    @NotNull Double length();

    /**
     * Calculate the squared length of this vector.
     *
     * @return The squared length of this vector.
     */
    @NotNull Double lengthSquared();

    /**
     * Calculate the distance between this vector and another vector.
     *
     * @param other The other vector.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return The distance between the vectors.
     */
    @NotNull Double distance( @NotNull Vector<T> other);

    /**
     * Calculate the squared distance between this vector and another vector.
     *
     * @param other The other vector.
     * @throws IllegalArgumentException If the vectors are not of the same arity.
     * @return The squared distance between the vectors.
     */
    @NotNull Double distanceSquared(@NotNull Vector<T> other);

    /**
     * Convert this vector to an array.
     *
     * @return The array representation of this vector.
     */
    @NotNull T[] toArray();

}
