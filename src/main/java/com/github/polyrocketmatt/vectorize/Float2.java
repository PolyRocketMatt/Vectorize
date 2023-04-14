package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

public record Float2(float x, float y) implements Vector2<Float> {

    @Override
    public @NotNull Float2 add(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x + vector.x(), this.y + vector.y());
    }

    @Override
    public @NotNull Float2 subtract(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x - vector.x(), this.y - vector.y());
    }

    @Override
    public @NotNull Float2 multiply(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2(this.x * vector.x(), this.y * vector.y());
    }

    @Override
    public @NotNull Float2 divide(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        if (vector.x() == 0.0f || vector.y() == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f)".formatted(vector.x(), vector.y()));
        return new Float2(this.x / vector.x(), this.y / vector.y());
    }

    @Override
    public @NotNull Float2 pow(@NotNull Vector<Float> other) throws IllegalArgumentException {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        return new Float2((float) Math.pow(this.x, vector.x()), (float) Math.pow(this.y, vector.y()));
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
        return x * vector.x() + y * vector.y();
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
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
    public @NotNull Double distance(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Float> other) {
        if (!(other instanceof Float2 vector))
            throw new IllegalArgumentException("'other' must be a Float2, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
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