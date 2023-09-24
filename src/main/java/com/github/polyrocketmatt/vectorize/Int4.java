package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 4-dimensional vector of integers.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Int4 extends Vector4<Integer> {

    protected final int x;
    protected final int y;
    protected final int z;
    protected final int w;

    public static final Int4 ZERO = new Int4(0, 0, 0, 0);
    public static final Int4 ONE = new Int4(1, 1, 1, 1);
    public static final Int4 UNIT_X = new Int4(1, 0, 0, 0);
    public static final Int4 UNIT_Y = new Int4(0, 1, 0, 0);
    public static final Int4 UNIT_Z = new Int4(0, 0, 1, 0);
    public static final Int4 UNIT_W = new Int4(0, 0, 0, 1);

    public Int4(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Int4(@NotNull Integer[] array) {
        if (array.length != 4)
            throw new IllegalArgumentException("'array' must have a length of 4, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
        this.w = array[3];
    }

    public Int4(Double4 vector) {
        this.x = (int) vector.x;
        this.y = (int) vector.y;
        this.z = (int) vector.z;
        this.w = (int) vector.w;
    }

    public Int4(Float4 vector) {
        this.x = (int) vector.x;
        this.y = (int) vector.y;
        this.z = (int) vector.z;
        this.w = (int) vector.w;
    }

    public Int4(int scalar) {
        this.x = scalar;
        this.y = scalar;
        this.z = scalar;
        this.w = scalar;
    }

    @Override
    public @NotNull Int4 add(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        return new Int4(this.x + vector.x, this.y + vector.y, this.z + vector.z, this.w + vector.w);
    }

    @Override
    public @NotNull Int4 subtract(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        return new Int4(this.x - vector.x, this.y - vector.y, this.z - vector.z, this.w - vector.w);
    }

    @Override
    public @NotNull Int4 multiply(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        return new Int4(this.x * vector.x, this.y * vector.y, this.z * vector.z, this.w * vector.w);
    }

    @Override
    public @NotNull Int4 divide(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0 || vector.y == 0 || vector.z == 0 || vector.w == 0)
            throw new ArithmeticException("'other' cannot have a zero component (x: %d, y: %d, z: %d, w: %d)".formatted(vector.x, vector.y, vector.z, vector.w));
        return new Int4(this.x / vector.x, this.y / vector.y, this.z / vector.z, this.w / vector.w);
    }

    @Override
    public @NotNull Int4 pow(@NotNull Vector<Integer> other) throws IllegalArgumentException {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        return new Int4((int) Math.pow(this.x, vector.x), (int) Math.pow(this.y, vector.y), (int) Math.pow(this.z, vector.z), (int) Math.pow(this.w, vector.w));
    }

    @Override
    public @NotNull Int4 add(@NotNull Integer scalar) {
        return new Int4(this.x + scalar, this.y + scalar, this.z + scalar, this.w + scalar);
    }

    @Override
    public @NotNull Int4 subtract(@NotNull Integer scalar) {
        return new Int4(this.x - scalar, this.y - scalar, this.z - scalar, this.w - scalar);
    }

    @Override
    public @NotNull Int4 multiply(@NotNull Integer scalar) {
        return new Int4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    @Override
    public @NotNull Int4 divide(@NotNull Integer scalar) {
        if (scalar == 0)
            throw new ArithmeticException("'other' cannot be zero");
        return new Int4(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    @Override
    public @NotNull Int4 pow(@NotNull Integer scalar) {
        return new Int4((int) Math.pow(this.x, scalar), (int) Math.pow(this.y, scalar), (int) Math.pow(this.z, scalar), (int) Math.pow(this.w, scalar));
    }

    @Override
    public @NotNull Int4 negate() {
        return new Int4(-this.x, -this.y, -this.z, -this.w);
    }

    @Override
    public @NotNull Int4 abs() {
        return new Int4(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }

    @Override
    public @NotNull Double4 normalize() {
        double length = this.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double4(this.x / length, this.y / length, this.z / length, this.w / length);
    }

    @Override
    public @NotNull Integer dot(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y + z * vector.z + w * vector.w;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
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
        return (double) x * x + y * y + z * z + w * w;
    }

    @Override
    public @NotNull Double distance(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        double dw = this.w - vector.w;
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Integer> other) {
        if (!(other instanceof Int4 vector))
            throw new IllegalArgumentException("'other' must be a Int4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        double dw = this.w - vector.w;
        return (dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Integer[] toArray() {
        return new Integer[] {this.x, this.y, this.z, this.w};
    }

    @Override
    public @NotNull Int4 floor() {
        return this;
    }

    @Override
    public @NotNull Int4 ceil() {
        return this;
    }

    @Override
    public @NotNull Int4 fract() {
        return this;
    }

    /**
     * Converts the vector to an {@link Double4}.
     *
     * @return A new Double4 with the same components as this vector.
     */
    public Double4 toDouble() {
        return new Double4(this.x, this.y, this.z, this.w);
    }

    /**
     * Converts the vector to an {@link Float4}.
     *
     * @return A new Float4 with the same components as this vector.
     */
    public Float4 toFloat() {
        return new Float4(this.x, this.y, this.z, this.w);
    }

    @Override
    public String toString() {
        return "Int4(%d, %d, %d, %d)".formatted(this.x, this.y, this.z, this.w);
    }
}