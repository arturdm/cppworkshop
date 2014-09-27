package cpp.android.obfuscatedkeyprovider;

public class JavaKeyProvider implements KeyProvider {

    @Override
    public String provide() {
        return "deadbaca";
    }
}
