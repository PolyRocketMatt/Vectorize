package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 2-dimensional vector of integers.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public record Int2(int x, int y) implements Vector2<Integer> {

    @Override
    public @NotNull Int2 add(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        return new Int2(this.x + vector.x(), this.y + vector.y());
    }

    @Override
    public @NotNull Int2 subtract(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        return new Int2(this.x - vector.x(), this.y - vector.y());
    }

    @Override
    public @NotNull Int2 multiply(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        return new Int2(this.x * vector.x(), this.y * vector.y());
    }

    @Override
    public @NotNull Int2 divide(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        if (vector.x() == 0.0f || vector.y() == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %d, y: %d)".formatted(vector.x(), vector.y()));
        return new Int2(this.x / vector.x(), this.y / vector.y());
    }

    @Override
    public @NotNull Int2 pow(@NotNull Vector<Integer> other) throws IllegalArgumentException {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        return new Int2((int) Math.pow(this.x, vector.x()), (int) Math.pow(this.y, vector.y()));
    }

    @Override
    public @NotNull Int2 add(@NotNull Integer scalar) {
        return new Int2(this.x + scalar, this.y + scalar);
    }

    @Override
    public @NotNull Int2 subtract(@NotNull Integer scalar) {
        return new Int2(this.x - scalar, this.y - scalar);
    }

    @Override
    public @NotNull Int2 multiply(@NotNull Integer scalar) {
        return new Int2(this.x * scalar, this.y * scalar);
    }

    @Override
    public @NotNull Int2 divide(@NotNull Integer scalar) {
        if (scalar == 0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Int2(this.x / scalar, this.y / scalar);
    }

    @Override
    public @NotNull Int2 pow(@NotNull Integer scalar) {
        return new Int2((int) Math.pow(this.x, scalar), (int) Math.pow(this.y, scalar));
    }

    @Override
    public @NotNull Int2 negate() {
        return new Int2(-this.x, -this.y);
    }

    @Override
    public @NotNull Int2 abs() {
        return new Int2(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public @NotNull Double2 normalize() {
        double length = this.length();
        if (length == 0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double2(this.x / length, this.y / length);
    }

    @Override
    public @NotNull Integer dot(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        return x * vector.x() + y * vector.y();
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2 vector, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double det = this.x * vector.y() - this.y * vector.x();
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
    public @NotNull Double distance(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int2 vector))
            throw new IllegalArgumentException("'other' must be a Int2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        return dx * dx + dy * dy;
    }

    @Override
    public @NotNull Double2 rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Double2(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }

    @Override
    public @NotNull Integer[] toArray() {
        return new Integer[] {this.x, this.y};
    }

    /**
     * Converts the vector to an {@link Double2}.
     *
     * @return A new Double2 with the same components as this vector.
     */
    public Double2 toDouble() {
        return new Double2(this.x, this.y);
    }

    /**
     * Converts the vector to an {@link Float2}.
     *
     * @return A new Float2 with the same components as this vector.
     */
    public Float2 toFloat() {
        return new Float2(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Int2(%d, %d)".formatted(this.x, this.y);
    }
}