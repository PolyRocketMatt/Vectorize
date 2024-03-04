package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Represents an immutable 4-dimensional vector of floats.
 *
 * @author Matthias Kovacic
 * @since 1.0.0
 */
public class Float4 extends Vector4<Float> {

    public final float x;
    public final float y;
    public final float z;
    public final float w;

    public static final Float4 ZERO = new Float4(0.0f, 0.0f, 0.0f, 0.0f);
    public static final Float4 ONE = new Float4(1.0f, 1.0f, 1.0f, 1.0f);
    public static final Float4 UNIT_X = new Float4(1.0f, 0.0f, 0.0f, 0.0f);
    public static final Float4 UNIT_Y = new Float4(0.0f, 1.0f, 0.0f, 0.0f);
    public static final Float4 UNIT_Z = new Float4(0.0f, 0.0f, 1.0f, 0.0f);
    public static final Float4 UNIT_W = new Float4(0.0f, 0.0f, 0.0f, 1.0f);

    public Float4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Float4(@NotNull Float[] array) {
        if (array.length != 4)
            throw new IllegalArgumentException("'array' must have a length of 4, found %d".formatted(array.length));
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
        this.w = array[3];
    }

    public Float4(Int4 vector) {
        this.x = (float) vector.x;
        this.y = (float) vector.y;
        this.z = (float) vector.z;
        this.w = (float) vector.w;
    }

    public Float4(Double4 vector) {
        this.x = (float) vector.x;
        this.y = (float) vector.y;
        this.z = (float) vector.z;
        this.w = (float) vector.w;
    }

    public Float4(float scalar) {
        this.x = scalar;
        this.y = scalar;
        this.z = scalar;
        this.w = scalar;
    }

    @Override
    public Float4 add(Float x, Float y, Float z, Float w) {
        return new Float4(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    @Override
    public Float4 subtract(Float x, Float y, Float z, Float w) {
        return new Float4(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    @Override
    public Float4 multiply(Float x, Float y, Float z, Float w) {
        return new Float4(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    @Override
    public Float4 divide(Float x, Float y, Float z, Float w) {
        if (x == 0.0f || y == 0.0f || z == 0.0f || w == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f, z: %f, w: %f)".formatted(x, y, z, w));
        return new Float4(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    @Override
    public @NotNull Float4 add(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        return new Float4(this.x + vector.x, this.y + vector.y, this.z + vector.z, this.w + vector.w);
    }

    @Override
    public @NotNull Float4 subtract(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        return new Float4(this.x - vector.x, this.y - vector.y, this.z - vector.z, this.w - vector.w);
    }

    @Override
    public @NotNull Float4 multiply(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        return new Float4(this.x * vector.x, this.y * vector.y, this.z * vector.z, this.w * vector.w);
    }

    @Override
    public @NotNull Float4 divide(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        if (vector.x == 0.0f || vector.y == 0.0f || vector.z == 0.0f || vector.w == 0.0f)
            throw new ArithmeticException("'other' cannot have a zero component (x: %f, y: %f, z: %f, w: %f)".formatted(vector.x, vector.y, vector.z, vector.w));
        return new Float4(this.x / vector.x, this.y / vector.y, this.z / vector.z, this.w / vector.w);
    }

    @Override
    public @NotNull Float4 pow(@NotNull Vector<Float> other) throws IllegalArgumentException {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        return new Float4(
                (float) Math.pow(this.x, vector.x), (float) Math.pow(this.y, vector.y),
                (float) Math.pow(this.z, vector.z), (float) Math.pow(this.w, vector.w)
        );
    }

    @Override
    public @NotNull Float4 add(@NotNull Float scalar) {
        return new Float4(this.x + scalar, this.y + scalar, this.z + scalar, this.w + scalar);
    }

    @Override
    public @NotNull Float4 subtract(@NotNull Float scalar) {
        return new Float4(this.x - scalar, this.y - scalar, this.z - scalar, this.w - scalar);
    }

    @Override
    public @NotNull Float4 multiply(@NotNull Float scalar) {
        return new Float4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    @Override
    public @NotNull Float4 divide(@NotNull Float scalar) {
        if (scalar == 0.0f)
            throw new ArithmeticException("'other' cannot be zero");
        return new Float4(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    @Override
    public @NotNull Float4 pow(@NotNull Float scalar) {
        return new Float4(
                (float) Math.pow(this.x, scalar), (float) Math.pow(this.y, scalar),
                (float) Math.pow(this.z, scalar), (float) Math.pow(this.w, scalar)
        );
    }

    @Override
    public @NotNull Float4 negate() {
        return new Float4(-this.x, -this.y, -this.z, -this.w);
    }

    @Override
    public @NotNull Float4 abs() {
        return new Float4(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }

    @Override
    public @NotNull Double4 normalize() {
        double length = this.length();
        if (length == 0.0f)
            throw new IllegalArgumentException("Cannot normalize a zero-length vector");
        return new Double4(this.x / length, this.y / length, this.z / length, this.w / length);
    }

    @Override
    public @NotNull Float dot(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        return x * vector.x + y * vector.y + z * vector.z + w * vector.w;
    }

    @Override
    public @NotNull Double angle(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        double dot = this.dot(vector);
        double length = this.length() * vector.length();
        if (length == 0.0)
            throw new IllegalArgumentException("Cannot calculate the angle between a zero-length vector");
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
    public @NotNull Double distance(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        double dw = this.w - vector.w;
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Double distanceSquared(@NotNull Vector<Float> other) {
        if (!(other instanceof Float4 vector))
            throw new IllegalArgumentException("'other' must be a Float4, found %s".formatted(other.getClass().getName()));
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        double dw = this.w - vector.w;
        return (dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public @NotNull Float[] toArray() {
        return new Float[] {this.x, this.y, this.z, this.w};
    }

    @Override
    public @NotNull Int4 floor() {
        return new Int4((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z), (int) Math.floor(this.w));
    }

    @Override
    public @NotNull Int4 ceil() {
        return new Int4((int) Math.ceil(this.x), (int) Math.ceil(this.y), (int) Math.ceil(this.z), (int) Math.ceil(this.w));
    }

    @Override
    public @NotNull Float4 fract() {
        return this.subtract(this.floor().toFloat());
    }

    /**
     * Converts the vector to a {@link Double4}.
     *
     * @return A new Double4 with the same components as this vector.
     */
    public Double4 toDouble() {
        return new Double4(this.x, this.y, this.z, this.w);
    }

    /**
     * Converts the vector to a {@link Int4}.
     *
     * @return A new Double2 with the same components as this vector.
     */
    public Int4 toInt() {
        return new Int4((int) this.x, (int) this.y, (int) this.z, (int) this.w);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Float4 float4)) return false;
        return Float.compare(float4.x, x) == 0 && Float.compare(float4.y, y) == 0 && Float.compare(float4.z, z) == 0 && Float.compare(float4.w, w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "Float4(%f, %f, %f, %f)".formatted(this.x, this.y, this.z, this.w);
    }
}