package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 3-dimensional vector of integers.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Int3 extends Vector3<Integer> {

    public final int x;
    public final int y;
    public final int z;

    public static final Int3 ZERO = new Int3(0, 0, 0);
    public static final Int3 ONE = new Int3(1, 1, 1);
    public static final Int3 UNIT_X = new Int3(1, 0, 0);
    public static final Int3 UNIT_Y = new Int3(0, 1, 0);
    public static final Int3 UNIT_Z = new Int3(0, 0, 1);

    public Int3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Int3(@NotNull Integer[] array) {
        if (array.length != 3)
            throw new IllegalArgumentException("'array' must have a length of 3, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
    }

    public Int3(Float3 vector) {
        this.x = (int) vector.x;
        this.y = (int) vector.y;
        this.z = (int) vector.z;
    }

    public Int3(Double3 vector) {
        this.x = (int) vector.x;
        this.y = (int) vector.y;
        this.z = (int) vector.z;
    }

    public Int3(int scalar) {
        this.x = scalar;
        this.y = scalar;
        this.z = scalar;
    }

    @Override
    public Int3 add(Integer x, Integer y, Integer z) {
        return new Int3(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Int3 subtract(Integer x, Integer y, Integer z) {
        return new Int3(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Int3 multiply(Integer x, Integer y, Integer z) {
        return new Int3(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Int3 divide(Integer x, Integer y, Integer z) {
        if (x == 0 || y == 0 || z == 0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %d, y: %d, z: %d)".formatted(x, y, z));
        return new Int3(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public @NotNull Int3 add(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return new Int3(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    @Override
    public @NotNull Int3 subtract(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return new Int3(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    @Override
    public @NotNull Int3 multiply(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return new Int3(this.x * vector.x, this.y * vector.y, this.z * vector.z);
    }

    @Override
    public @NotNull Int3 divide(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0 || vector.y == 0 || vector.z == 0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %d, y: %d, z: %d)".formatted(vector.x, vector.y, vector.z));
        return new Int3(this.x / vector.x, this.y / vector.y, this.z / vector.z);
    }

    @Override
    public @NotNull Int3 pow(@NotNull Vector<Integer> other) throws IllegalArgumentException {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return new Int3((int) Math.pow(this.x, vector.x), (int) Math.pow(this.y, vector.y), (int) Math.pow(this.z, vector.z));
    }

    @Override
    public @NotNull Int3 add(@NotNull Integer scalar) {
        return new Int3(this.x + scalar, this.y + scalar, this.z + scalar);
    }

    @Override
    public @NotNull Int3 subtract(@NotNull Integer scalar) {
        return new Int3(this.x - scalar, this.y - scalar, this.z - scalar);
    }

    @Override
    public @NotNull Int3 multiply(@NotNull Integer scalar) {
        return new Int3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public @NotNull Int3 divide(@NotNull Integer scalar) {
        if (scalar == 0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Int3(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    @Override
    public @NotNull Int3 pow(@NotNull Integer scalar) {
        return new Int3((int) Math.pow(this.x, scalar), (int) Math.pow(this.y, scalar), (int) Math.pow(this.z, scalar));
    }

    @Override
    public @NotNull Int3 negate() {
        return new Int3(-this.x, -this.y, -this.z);
    }

    @Override
    public @NotNull Int3 abs() {
        return new Int3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public @NotNull Double3 normalize() {
        double length = this.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double3(this.x / length, this.y / length, this.z / length);
    }

    @Override
    public @NotNull Integer dot(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y + z * vector.z;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double cross = this.cross(vector).length();
        return Math.atan2(cross, dot);
    }

    @Override
    public @NotNull Vector<Integer> cross(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        return new Int3(
                this.y * vector.z - this.z * vector.y,
                this.z * vector.x - this.x * vector.z,
                this.x * vector.y - this.y * vector.x
        );
    }

    @Override
    public @NotNull Double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public @NotNull Double lengthSquared() {
        return (double) x * x + y * y + z * z;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int3 vector))
            throw new IllegalArgumentException("'other' must be a Int3, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
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
    public @NotNull Integer[] toArray() {
        return new Integer[] {this.x, this.y, this.z};
    }

    @Override
    public @NotNull Int3 floor() {
        return this;
    }

    @Override
    public @NotNull Int3 ceil() {
        return this;
    }

    @Override
    public @NotNull Int3 fract() {
        return this;
    }

    @Override
    public Int3 zyx() {
        return new Int3(this.z, this.y, this.x);
    }

    /**
     * Converts the vector to an {@link Double3}.
     *
     * @return A new Double3 with the same components as this vector.
     */
    public Double3 toDouble() {
        return new Double3(this.x, this.y, this.z);
    }

    /**
     * Converts the vector to an {@link Float3}.
     *
     * @return A new Float3 with the same components as this vector.
     */
    public Float3 toFloat() {
        return new Float3(this.x, this.y, this.z);
    }

    @Override
    public String toString() {
        return "Int3(%d, %d, %d)".formatted(this.x, this.y, this.z);
    }
}