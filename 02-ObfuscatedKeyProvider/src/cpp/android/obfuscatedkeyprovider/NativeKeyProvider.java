package cpp.android.obfuscatedkeyprovider;

public class NativeKeyProvider implements KeyProvider {

    static {
        System.loadLibrary("app");
    }

    @Override
    public native String provide();
}
