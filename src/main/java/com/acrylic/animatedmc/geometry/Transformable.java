package com.acrylic.animatedmc.geometry;

import com.acrylic.animatedmc.math.Matrix3;

import javax.annotation.Nullable;

public interface Transformable {

    @Nullable
    Matrix3 getTransformationMatrix();

    void setTransformationMatrix(@Nullable Matrix3 matrix);

}
