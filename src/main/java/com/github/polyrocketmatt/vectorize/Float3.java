package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable 3-dimensional vector of floats.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Float3 extends Vector3<Float> {

    protected final float x;
    protected final float y;
    protected final float z;

    public static final Float3 ZERO = new Float3(0.0f, 0.0f, 0.0f);
    public static final Float3 ONE = new Float3(1.0f, 1.0f, 1.0f);
    public static final Float3 UNIT_X = new Float3(1.0f, 0.0f, 0.0f);
    public static final Float3 UNIT_Y = new Float3(0.0f, 1.0f, 0.0f);
    public static final Float3 UNIT_Z = new Float3(0.0f, 0.0f, 1.0f);

    public Float3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Float3(@NotNull Float[] array) {
        if (array.length != 3)
            throw new IllegalArgumentException("'array' must have a length of 3, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
    }

    public Float3(Int3 vector) {
        this.x = (float) vector.x;
        this.y = (float) vector.y;
        this.z = (float) vector.z;
    }

    public Float3(Double3 vector) {
        this.x = (float) vector.x;
        this.y = (float) vector.y;
        this.z = (float) vector.z;
    }

    public Float3(float scalar) {
        this.x = scalar;
        this.y = scalar;
        this.z = scalar;
    }

    @Override
    public @NotNull Float3 add(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return new Float3(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    @Override
    public @NotNull Float3 subtract(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return new Float3(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    @Override
    public @NotNull Float3 multiply(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return new Float3(this.x * vector.x, this.y * vector.y, this.z * vector.z);
    }

    @Override
    public @NotNull Float3 divide(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0.0f || vector.y == 0.0f || vector.z == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f, z: %f)".formatted(vector.x, vector.y, vector.z));
        return new Float3(this.x / vector.x, this.y / vector.y, this.z / vector.z);
    }

    @Override
    public @NotNull Float3 pow(@NotNull Vector<Float> other) throws IllegalArgumentException {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return new Float3((float) Math.pow(this.x, vector.x), (float) Math.pow(this.y, vector.y), (float) Math.pow(this.z, vector.z));
    }

    @Override
    public @NotNull Float3 add(@NotNull Float scalar) {
        return new Float3(this.x + scalar, this.y + scalar, this.z + scalar);
    }

    @Override
    public @NotNull Float3 subtract(@NotNull Float scalar) {
        return new Float3(this.x - scalar, this.y - scalar, this.z - scalar);
    }

    @Override
    public @NotNull Float3 multiply(@NotNull Float scalar) {
        return new Float3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public @NotNull Float3 divide(@NotNull Float scalar) {
        if (scalar == 0.0f)
            throw new ArithmeticException("'other' cannot be zero");
        return new Float3(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    @Override
    public @NotNull Float3 pow(@NotNull Float scalar) {
        return new Float3((float) Math.pow(this.x, scalar), (float) Math.pow(this.y, scalar), (float) Math.pow(this.z, scalar));
    }

    @Override
    public @NotNull Float3 negate() {
        return new Float3(-this.x, -this.y, -this.z);
    }

    @Override
    public @NotNull Float3 abs() {
        return new Float3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public @NotNull Double3 normalize() {
        double length = this.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double3(this.x / length, this.y / length, this.z / length);
    }

    @Override
    public @NotNull Float dot(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y + z * vector.z;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double cross = this.cross(vector).length();
        return Math.atan2(cross, dot);
    }

    public @NotNull Float3 cross(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        return new Float3(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x
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
    public @NotNull Double distance(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Float> other) {
        if (!(other instanceof Float3 vector))
            throw new IllegalArgumentException("'other' must be a Float3, found %s".formatted(other.getClass().getName()));
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
    public @NotNull Float[] toArray() {
        return new Float[] {this.x, this.y, this.z};
    }

    @Override
    public @NotNull Int3 floor() {
        return new Int3((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z));
    }

    @Override
    public @NotNull Int3 ceil() {
        return new Int3((int) Math.ceil(this.x), (int) Math.ceil(this.y), (int) Math.ceil(this.z));
    }

    @Override
    public @NotNull Float3 fract() {
        return this.subtract(this.floor().toFloat());
    }

    @Override
    public Float3 zyx() {
        return new Float3(this.z, this.y, this.x);
    }

    /**
     * Converts the vector to a {@link Double3}.
     *
     * @return A new Double3 with the same components as this vector.
     */
    public Double3 toDouble() {
        return new Double3(this.x, this.y, this.z);
    }

    /**
     * Converts the vector to a {@link Int3}.
     *
     * @return A new Double2 with the same components as this vector.
     */
    public Int3 toInt() {
        return new Int3((int) this.x, (int) this.y, (int) this.z);
    }

    @Override
    public String toString() {
        return "Float3(%f, %f, %f)".formatted(this.x, this.y, this.z);
    }
}