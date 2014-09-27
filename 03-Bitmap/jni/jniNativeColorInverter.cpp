
#include "jniNativeColorInverter.h"

#include "Inverter.h"

JNIEXPORT void JNICALL Java_cpp_android_bitmap_NativeColorInverter_invertColorsIn
  (JNIEnv *env, jobject, jobject bitmap) {
	android::invert(env, bitmap);
}
