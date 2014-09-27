LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := app
LOCAL_LDLIBS	:= -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)
