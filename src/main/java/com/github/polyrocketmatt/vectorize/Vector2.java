package com.github.polyrocketmatt.vectorize;

import org.jetbrains.annotations.NotNull;

public interface Vector2<T> extends Vector<T> {

    /**
     * Rotates the vector by the given angle in radians.
     *
     * @param angle The angle in radians.
     * @return A new vector rotated by the given angle.
     */
    @NotNull Vector<Double> rotate(double angle);

}
