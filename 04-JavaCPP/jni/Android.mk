LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := app
LOCAL_SRC_FILES	:= jniNativeColorInverter.cpp
LOCAL_CPPFLAGS	:= -fexceptions
LOCAL_LDLIBS	:= -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)
