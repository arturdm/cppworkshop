package cpp.android.bitmap;

import android.graphics.Bitmap;

public class JavaColorInverter implements ColorInverter {

    @Override
    public void invertColorsIn(Bitmap bitmap) {
    	int[] pixels = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int index = 0; index < pixels.length; ++index) {
            int r = 0x00FF0000 - (pixels[index] & 0x00FF0000);
            int g = 0x0000FF00 - (pixels[index] & 0x0000FF00);
            int b = 0x000000FF - (pixels[index] & 0x000000FF);
            pixels[index] = (0xFF << 24) | r | g | b;
        }
        bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }
    
}
