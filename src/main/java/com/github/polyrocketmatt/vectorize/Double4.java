package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 4-dimensional vector of doubles.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public record Double4(double x, double y, double z, double w) implements Vector4<Double> {

    @Override
    public @NotNull Double4 add(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        return new Double4(this.x + vector.x(), this.y + vector.y(), this.z + vector.z(), this.w + vector.w());
    }

    @Override
    public @NotNull Double4 subtract(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        return new Double4(this.x - vector.x(), this.y - vector.y(), this.z - vector.z(), this.w - vector.w());
    }

    @Override
    public @NotNull Double4 multiply(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        return new Double4(this.x * vector.x(), this.y * vector.y(), this.z * vector.z(), this.w * vector.w());
    }

    @Override
    public @NotNull Double4 divide(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        if (vector.x() == 0.0 || vector.y() == 0.0 || vector.z() == 0.0 || vector.w() == 0.0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f, z: %f, w: %f)".formatted(vector.x(), vector.y(), vector.z(), vector.w()));
        return new Double4(this.x / vector.x(), this.y / vector.y(), this.z / vector.z(), this.w / vector.w());
    }

    @Override
    public @NotNull Double4 pow(@NotNull Vector<Double> other) throws IllegalArgumentException {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        return new Double4(Math.pow(this.x, vector.x()), Math.pow(this.y, vector.y()), Math.pow(this.z, vector.z()), Math.pow(this.w, vector.w()));
    }

    @Override
    public @NotNull Double4 add(@NotNull Double scalar) {
        return new Double4(this.x + scalar, this.y + scalar, this.z + scalar, this.w + scalar);
    }

    @Override
    public @NotNull Double4 subtract(@NotNull Double scalar) {
        return new Double4(this.x - scalar, this.y - scalar, this.z - scalar, this.w - scalar);
    }

    @Override
    public @NotNull Double4 multiply(@NotNull Double scalar) {
        return new Double4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    @Override
    public @NotNull Double4 divide(@NotNull Double scalar) {
        if (scalar == 0.0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Double4(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    @Override
    public @NotNull Double4 pow(@NotNull Double scalar) {
        return new Double4(Math.pow(this.x, scalar), Math.pow(this.y, scalar), Math.pow(this.z, scalar), Math.pow(this.w, scalar));
    }

    @Override
    public @NotNull Double4 negate() {
        return new Double4(-this.x, -this.y, -this.z, -this.w);
    }

    @Override
    public @NotNull Double4 abs() {
        return new Double4(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }

    @Override
    public @NotNull Double4 normalize() {
        double length = this.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double4(this.x / length, this.y / length, this.z / length, this.w / length);
    }

    @Override
    public @NotNull Double dot(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        return x * vector.x() + y * vector.y() + z * vector.z() + w * vector.w();
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double length = this.length() * vector.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot calculate the angle between two zero-length vectors");
        return Math.acos(dot / length);
    }

    @Override
    public @NotNull Double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public @NotNull Double lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        double dz = this.z - vector.z();
        double dw = this.w - vector.w();
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Double> other) {
        if (!(other instanceof Double4 vector))
            throw new IllegalArgumentException("'other' must be a Double4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        double dz = this.z - vector.z();
        double dw = this.w - vector.w();
        return (dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Double[] toArray() {
        return new Double[] {this.x, this.y, this.z, this.w};
    }

    /**
     * Converts the vector to an {@link Int4}.
     *
     * @return A new Int4 the same components as this vector.
     */
    public @NotNull Int4 toInt() {
        return new Int4((int) this.x, (int) this.y, (int) this.z, (int) this.w);
    }

    /**
     * Converts the vector to a {@link Float4}.
     *
     * @return A new Float4 the same components as this vector.
     */
    public @NotNull Float4 toFloat() {
        return new Float4((float) this.x, (float) this.y, (float) this.z, (float) this.w);
    }

    @Override
    public String toString() {
        return "Double4(%f, %f, %f, %f)".formatted(this.x, this.y, this.z, this.w);
    }
}