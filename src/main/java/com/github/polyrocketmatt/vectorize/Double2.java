package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 2-dimensional vector of doubles.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Double2 extends Vector2<Double> {

    protected final double x;
    protected final double y;

    public static final Double2 ZERO = new Double2(0.0, 0.0);
    public static final Double2 ONE = new Double2(1.0, 1.0);
    public static final Double2 UNIT_X = new Double2(1.0, 0.0);
    public static final Double2 UNIT_Y = new Double2(0.0, 1.0);

    public Double2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double2(@NotNull Double[] array) {
        if (array.length != 2)
            throw new IllegalArgumentException("'array' must have a length of 2, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
    }

    public Double2(Int2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Double2(Float2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Double2(double scalar) {
        this.x = scalar;
        this.y = scalar;
    }

    @Override
    public @NotNull Double2 add(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        return new Double2(this.x + vector.x, this.y + vector.y);
    }

    @Override
    public @NotNull Double2 subtract(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        return new Double2(this.x - vector.x, this.y - vector.y);
    }

    @Override
    public @NotNull Double2 multiply(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        return new Double2(this.x * vector.x, this.y * vector.y);
    }

    @Override
    public @NotNull Double2 divide(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0.0 || vector.y == 0.0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f)".formatted(vector.x, vector.y));
        return new Double2(this.x / vector.x, this.y / vector.y);
    }

    @Override
    public @NotNull Double2 pow(@NotNull Vector<Double> other) throws IllegalArgumentException {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        return new Double2(Math.pow(this.x, vector.x), Math.pow(this.y, vector.y));
    }

    @Override
    public @NotNull Double2 add(@NotNull Double scalar) {
        return new Double2(this.x + scalar, this.y + scalar);
    }

    @Override
    public @NotNull Double2 subtract(@NotNull Double scalar) {
        return new Double2(this.x - scalar, this.y - scalar);
    }

    @Override
    public @NotNull Double2 multiply(@NotNull Double scalar) {
        return new Double2(this.x * scalar, this.y * scalar);
    }

    @Override
    public @NotNull Double2 divide(@NotNull Double scalar) {
        if (scalar == 0.0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Double2(this.x / scalar, this.y / scalar);
    }

    @Override
    public @NotNull Vector<Double> pow(@NotNull Double scalar) {
        return new Double2(Math.pow(this.x, scalar), Math.pow(this.y, scalar));
    }

    @Override
    public @NotNull Double2 negate() {
        return new Double2(-this.x, -this.y);
    }

    @Override
    public @NotNull Vector<Double> abs() {
        return new Double2(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public @NotNull Double2 normalize() {
        double length = this.length();
        if (length == 0.0f)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double2(this.x / length, this.y / length);
    }

    @Override
    public @NotNull Double dot(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
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
        return x * x + y * y;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Double> other) {
        if (!(other instanceof Double2 vector))
            throw new IllegalArgumentException("'other' must be a Double2, found %s".formatted(other.getClass().getName()));
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
    public @NotNull Double[] toArray() {
        return new Double[] {this.x, this.y};
    }

    @Override
    public @NotNull Int2 floor() {
        return new Int2((int) Math.floor(this.x), (int) Math.floor(this.y));
    }

    @Override
    public @NotNull Int2 ceil() {
        return new Int2((int) Math.ceil(this.x), (int) Math.ceil(this.y));
    }

    @Override
    public @NotNull Double2 fract() {
        return this.subtract(this.floor().toDouble());
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    public Double2 yx() {
        return new Double2(this.y, this.x);
    }

    /**
     * Converts the vector to an {@link Int2}.
     *
     * @return A new Int2 with the same components as this vector.
     */
    public @NotNull Int2 toInt() {
        return new Int2((int) this.x, (int) this.y);
    }

    /**
     * Converts the vector to a {@link Float2}.
     *
     * @return A new Float2 with the same components as this vector.
     */
    public @NotNull Float2 toFloat() {
        return new Float2((float) this.x, (float) this.y);
    }

    @Override
    public String toString() {
        return "Double2(%f, %f)".formatted(this.x, this.y);
    }
}