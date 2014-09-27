package cpp.android.keyprovider;

public class NativeKeyProvider implements KeyProvider {

	static {
		System.loadLibrary("app");
	}
	
	@Override
	public native String provide();
}
