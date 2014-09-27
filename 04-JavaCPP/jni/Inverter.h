#pragma once

#include "LogHelper.h"
#include <android/bitmap.h>

namespace android {

namespace internal {

void invertPixel(uint32_t* pixel) {
    *pixel = 0xFF000000 |
            (0x00FF0000 - (*pixel & 0x00FF0000)) |
            (0x0000FF00 - (*pixel & 0x0000FF00)) |
            (0x000000FF - (*pixel & 0x000000FF));
}

void invert(AndroidBitmapInfo* info, void* pixels) {
    LOGI("inverting %dx%d bitmap", info->width, info->height);
    int pixelCount = info->width * info->height;
    uint32_t* pixel = (uint32_t*) pixels;

    for (int index = 0; index < pixelCount; ++pixel, ++index) {
        invertPixel(pixel);
    }
}

}

void invert(JNIEnv* env, jobject bitmap) {
    AndroidBitmapInfo info;
    int ret;
    void* pixels;

    if ((ret = AndroidBitmap_getInfo(env, bitmap, &info)) < 0) {
            LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
            return;
        }
    if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888) {
        LOGE("Bitmap format is not RGBA_8888 !");
        return;
    }

    if ((ret = AndroidBitmap_lockPixels(env, bitmap, &pixels)) < 0) {
        LOGE("AndroidBitmap_lockPixels() failed ! error=%d", ret);
    }

    internal::invert(&info, pixels);

    AndroidBitmap_unlockPixels(env, bitmap);
}


}
