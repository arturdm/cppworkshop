#include "jniNativeKeyProvider.h"

#include "ADVobfuscator/MetaString4.h"

using namespace andrivet::ADVobfuscator;

JNIEXPORT jstring JNICALL Java_cpp_android_obfuscatedkeyprovider_NativeKeyProvider_provide(JNIEnv *env, jobject object) {
    return env->NewStringUTF(OBFUSCATED4("deadbaca"));
}
