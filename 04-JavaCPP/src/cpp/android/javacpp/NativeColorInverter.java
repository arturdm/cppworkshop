package cpp.android.javacpp;

import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Raw;

import android.graphics.Bitmap;

@Platform(include = "NativeColorInverter.h", link = "app")
@Namespace("android")
public class NativeColorInverter extends Pointer implements ColorInverter {

	static {
		System.loadLibrary("app");
	}
	
	public NativeColorInverter() {
		allocate();
	}
	
	private native void allocate();
	
	@Override
	public native void invertColorsIn(@Raw(withEnv=true) Bitmap bitmap);
}
