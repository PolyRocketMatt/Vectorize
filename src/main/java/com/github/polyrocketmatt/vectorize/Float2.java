package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 2-dimensional vector of floats.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Float2 extends Vector2<Float> {

    protected final float x;
    protected final float y;

    public static final Float2 ZERO = new Float2(0.0f, 0.0f);
    public static final Float2 ONE = new Float2(1.0f, 1.0f);
    public static final Float2 UNIT_X = new Float2(1.0f, 0.0f);
    public static final Float2 UNIT_Y = new Float2(0.0f, 1.0f);

    public Float2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Float2(@NotNull Float[] array) {
        if (array.length != 2)
            throw new IllegalArgumentException("'array' must have a length of 2, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
    }

    public Float2(Int2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Float2(Double2 vector) {
        this.x = (float) vector.x;
        this.y = (float) vector.y;
    }

    public Float2(float scalar) {
        this.x = scalar;
        this.y = scalar;
    }

    @Override
    public @NotNull Float2 add(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x + vector.x, this.y + vector.y);
    }

    @Override
    public @NotNull Float2 subtract(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x - vector.x, this.y - vector.y);
    }

    @Override
    public @NotNull Float2 multiply(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x * vector.x, this.y * vector.y);
    }

    @Override
    public @NotNull Float2 divide(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0.0f || vector.y == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f)".formatted(vector.x, vector.y));
        return new Float2(this.x / vector.x, this.y / vector.y);
    }

    @Override
    public @NotNull Float2 pow(@NotNull Vector<Float> other) throws IllegalArgumentException {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2((float) Math.pow(this.x, vector.x), (float) Math.pow(this.y, vector.y));
    }

    @Override
    public @NotNull Float2 add(@NotNull Float scalar) {
        return new Float2(this.x + scalar, this.y + scalar);
    }

    @Override
    public @NotNull Float2 subtract(@NotNull Float scalar) {
        return new Float2(this.x - scalar, this.y - scalar);
    }

    @Override
    public @NotNull Float2 multiply(@NotNull Float scalar) {
        return new Float2(this.x * scalar, this.y * scalar);
    }

    @Override
    public @NotNull Float2 divide(@NotNull Float scalar) {
        if (scalar == 0.0f)
            throw new ArithmeticException("'other' cannot be zero");
        return new Float2(this.x / scalar, this.y / scalar);
    }

    @Override
    public @NotNull Float2 pow(@NotNull Float scalar) {
        return new Float2((float) Math.pow(this.x, scalar), (float) Math.pow(this.y, scalar));
    }

    @Override
    public @NotNull Float2 negate() {
        return new Float2(-this.x, -this.y);
    }

    @Override
    public @NotNull Float2 abs() {
        return new Float2(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public @NotNull Double2 normalize() {
        double length = this.length();
        if (length == 0.0f)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double2(this.x / length, this.y / length);
    }

    @Override
    public @NotNull Float dot(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double det = this.x * vector.y - this.y * vector.x;
        return Math.atan2(det, dot);
    }

    @Override
    public @NotNull Double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public @NotNull Double lengthSquared() {
        return (double) x * x + y * y;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        return (dx * dx + dy * dy);
    }

    @Override
    public @NotNull Double2 rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Double2(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }

    @Override
    public @NotNull Float[] toArray() {
        return new Float[] {this.x, this.y};
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    public Float2 yx() {
        return new Float2(this.y, this.x);
    }

    /**
     * Converts the vector to a {@link Double2}.
     *
     * @return A new Double2 with the same components as this vector.
     */
    public Double2 toDouble() {
        return new Double2(this.x, this.y);
    }

    /**
     * Converts the vector to a {@link Int2}.
     *
     * @return A new Double2 with the same components as this vector.
     */
    public Int2 toInt() {
        return new Int2((int) this.x, (int) this.y);
    }

    @Override
    public String toString() {
        return "Float2(%f, %f)".formatted(this.x, this.y);
    }
}