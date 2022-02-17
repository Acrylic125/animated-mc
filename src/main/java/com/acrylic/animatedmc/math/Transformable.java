package com.acrylic.animatedmc.math;

import javax.annotation.Nullable;

public interface Transformable {

    @Nullable
    Matrix3 getTransformationMatrix();

    void setTransformationMatrix(@Nullable Matrix3 matrix);

}
