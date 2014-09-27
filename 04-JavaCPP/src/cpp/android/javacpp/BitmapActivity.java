package cpp.android.javacpp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class BitmapActivity extends Activity {

    private ColorInverter inverted = new NativeColorInverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        Bitmap icon = decodeBitmap();
        inverted.invertColorsIn(icon);
        
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(icon);
    }

    private Bitmap decodeBitmap() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher, options);
    }
}
