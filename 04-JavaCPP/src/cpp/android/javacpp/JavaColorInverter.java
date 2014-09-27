package cpp.android.javacpp;

import android.graphics.Bitmap;
import android.graphics.Color;

public class JavaColorInverter implements ColorInverter {

    @Override
    public void invertColorsIn(Bitmap bitmap) {
        quicklyInvertColorsIn(bitmap);
    }

    private void quicklyInvertColorsIn(Bitmap bitmap) {
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

    private void slowlyInvertColorsIn(Bitmap bitmap) {
        int[] pixels = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int index = 0; index < pixels.length; ++index) {
            int r = 0xFF - Color.red(pixels[index]);
            int g = 0xFF - Color.green(pixels[index]);
            int b = 0xFF - Color.blue(pixels[index]);
            pixels[index] = Color.rgb(r, g, b);
        }
        bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }
}
