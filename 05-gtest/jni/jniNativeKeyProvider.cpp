#include "jniNativeKeyProvider.h"
#include "NativeKeyProvider.h"

JNIEXPORT jstring JNICALL Java_cpp_android_gtest_NativeKeyProvider_provide(JNIEnv *env, jobject object) {
    return env->NewStringUTF(nativekeyprovider::provide().c_str());
}
