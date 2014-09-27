LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := app
LOCAL_SRC_FILES := jniNativeKeyProvider.cpp

include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := app_test
LOCAL_SRC_FILES := NativeKeyProviderTest.cpp
LOCAL_SHARED_LIBRARIES := app
LOCAL_STATIC_LIBRARIES := googletest_main

include $(BUILD_EXECUTABLE)
  
$(call import-module,third_party/googletest)