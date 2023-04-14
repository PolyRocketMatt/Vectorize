package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

public record Double3(double x, double y, double z) implements Vector3<Double> {

    @Override
    public @NotNull Double3 add(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return new Double3(this.x + vector.x(), this.y + vector.y(), this.z + vector.z());
    }

    @Override
    public @NotNull Double3 subtract(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return new Double3(this.x - vector.x(), this.y - vector.y(), this.z - vector.z());
    }

    @Override
    public @NotNull Double3 multiply(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return new Double3(this.x * vector.x(), this.y * vector.y(), this.z * vector.z());
    }

    @Override
    public @NotNull Double3 divide(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        if (vector.x() == 0.0 || vector.y() == 0.0 || vector.z() == 0.0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f, z: %f)".formatted(vector.x(), vector.y(), vector.z()));
        return new Double3(this.x / vector.x(), this.y / vector.y(), this.z / vector.z());
    }

    @Override
    public @NotNull Double3 pow(@NotNull Vector<Double> other) throws IllegalArgumentException {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return new Double3(Math.pow(this.x, vector.x()), Math.pow(this.y, vector.y()), Math.pow(this.z, vector.z()));
    }

    @Override
    public @NotNull Double3 add(@NotNull Double scalar) {
        return new Double3(this.x + scalar, this.y + scalar, this.z + scalar);
    }

    @Override
    public @NotNull Double3 subtract(@NotNull Double scalar) {
        return new Double3(this.x - scalar, this.y - scalar, this.z - scalar);
    }

    @Override
    public @NotNull Double3 multiply(@NotNull Double scalar) {
        return new Double3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public @NotNull Double3 divide(@NotNull Double scalar) {
        if (scalar == 0.0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Double3(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    @Override
    public @NotNull Double3 pow(@NotNull Double scalar) {
        return new Double3(Math.pow(this.x, scalar), Math.pow(this.y, scalar), Math.pow(this.z, scalar));
    }

    @Override
    public @NotNull Double2 negate() {
        return new Double2(-this.x, -this.y);
    }

    @Override
    public @NotNull Double3 abs() {
        return new Double3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public @NotNull Double3 normalize() {
        double length = this.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double3(this.x / length, this.y / length, this.z / length);
    }

    @Override
    public @NotNull Double dot(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return x * vector.x() + y * vector.y() + z * vector.z();
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double cross = this.cross(vector).length();
        return Math.atan2(cross, dot);
    }

    @Override
    public @NotNull Double3 cross(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        return new Double3(
                this.y * vector.z() - this.z * vector.y(),
                this.z * vector.x() - this.x * vector.z(),
                this.x * vector.y() - this.y * vector.x()
        );
    }

    @Override
    public @NotNull Double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public @NotNull Double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        double dz = this.z - vector.z();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Double> other) {
        if (!(other instanceof Double3 vector))
            throw new IllegalArgumentException("'other' must be a Double3, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x();
        double dy = this.y - vector.y();
        double dz = this.z - vector.z();
        return (dx * dx + dy * dy + dz * dz);
    }

    @Override
    public @NotNull Double3 rotateX(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Double3(this.x, this.y * cos - this.z * sin, this.y * sin + this.z * cos);
    }

    @Override
    public @NotNull Double3 rotateY(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Double3(this.x * cos + this.z * sin, this.y, -this.x * sin + this.z * cos);
    }

    @Override
    public @NotNull Double3 rotateZ(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Double3(this.x * cos - this.y * sin, this.x * sin + this.y * cos, this.z);
    }

    @Override
    public @NotNull Double[] toArray() {
        return new Double[] {this.x, this.y, this.z};
    }

    /**
     * Converts the vector to an {@link Int3}.
     *
     * @return A new Int3 with the same components as this vector.
     */
    public @NotNull Int3 toInt() {
        return new Int3((int) this.x, (int) this.y, (int) this.z);
    }

    /**
     * Converts the vector to a {@link Float3}.
     *
     * @return A new Float3 the same components as this vector.
     */
    public @NotNull Float3 toFloat() {
        return new Float3((float) this.x, (float) this.y, (float) this.z);
    }

    @Override
    public String toString() {
        return "Double3(%f, %f, %f)".formatted(this.x, this.y, this.z);
    }
}