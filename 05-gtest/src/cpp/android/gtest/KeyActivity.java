package cpp.android.gtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class KeyActivity extends Activity {

	private KeyProvider keyProvider = new NativeKeyProvider();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key);

		updateKeyTextView();
	}

	private void updateKeyTextView() {
		TextView keyTextView = (TextView) findViewById(R.id.key);
		keyTextView.setText(keyProvider.provide());
	}
}
