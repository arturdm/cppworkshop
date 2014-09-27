package cpp.android.obfuscatedkeyprovider;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.TextView;

import org.fest.assertions.api.ANDROID;

public class KeyActivityTest extends ActivityUnitTestCase<KeyActivity> {

    public KeyActivityTest() {
        super(KeyActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                KeyActivity.class);
        startActivity(intent, null, null);
    }

    public void testShouldHaveProperKey() throws Exception {
        // given
        String expectedText = "deadbaca";
        TextView keyTextView = (TextView) getActivity().findViewById(R.id.key);

        // then
        ANDROID.assertThat(keyTextView).hasText(expectedText);
    }
}
