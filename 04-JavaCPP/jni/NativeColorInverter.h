#pragma once

#include <jni.h>
#include "Inverter.h"

namespace android {

class NativeColorInverter {
public:
	void invertColorsIn(JNIEnv* env, jobject, jobject bitmap) {
		android::invert(env, bitmap);
	}
};

}
