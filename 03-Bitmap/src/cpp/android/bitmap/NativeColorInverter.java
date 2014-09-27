package cpp.android.bitmap;

import android.graphics.Bitmap;

public class NativeColorInverter implements ColorInverter {

	static {
		System.loadLibrary("app");
	}
	
	@Override
	public native void invertColorsIn(Bitmap bitmap);

}
