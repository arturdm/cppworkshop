package cpp.android.keyprovider;

import android.test.AndroidTestCase;
import static org.fest.assertions.api.Assertions.assertThat;

public class KeyProviderTest<T extends KeyProvider> extends AndroidTestCase {

    private KeyProvider keyProvider;

    public KeyProviderTest(Class<T> keyProviderClass) {
        try {
            keyProvider = keyProviderClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void testShouldProvideKey() throws Exception {
        // given
        String expectedKey = "deadbaca";

        // when
        String actualKey = keyProvider.provide();

        // then
        assertThat(actualKey).isEqualTo(expectedKey);
    }
}
