/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.topeka.model;

import android.support.annotation.DrawableRes;

import com.google.samples.apps.topeka.R;

/**
 * The available avatars with their corresponding drawable resource ids.
 */
public enum Avatar {

    ONE(R.drawable.doge),
    TWO(R.drawable.yee),
    THREE(R.drawable.tri),
    FOUR(R.drawable.cat),
    FIVE(R.drawable.dogewoman),
    SIX(R.drawable.master),
    SEVEN(R.drawable.knife),
    EIGHT(R.drawable.white),
    NINE(R.drawable.zhai),
    TEN(R.drawable.song),
    ELEVEN(R.drawable.ma),
    TWELVE(R.drawable.zu),
    THIRTEEN(R.drawable.peter),
    FOURTEEN(R.drawable.jackie),
    FIFTEEN(R.drawable.yao),
    SIXTEEN(R.drawable.cage);

    private static final String TAG = "Avatar";

    private final int mResId;

    Avatar(@DrawableRes final int resId) {
        mResId = resId;
    }

    @DrawableRes
    public int getDrawableId() {
        return mResId;
    }

    public String getNameForAccessibility() {
        return TAG + " " + ordinal() + 1;
    }
}
