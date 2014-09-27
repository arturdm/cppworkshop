#include "jniNativeKeyProvider.h"

JNIEXPORT jstring JNICALL Java_cpp_android_keyprovider_NativeKeyProvider_provide
  (JNIEnv * env, jobject object) {
	return env->NewStringUTF("deadbaca");
}
