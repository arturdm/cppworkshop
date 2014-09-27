package cpp.android.javacpp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.test.AndroidTestCase;

import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;

public class ColorInverterTest<T extends ColorInverter> extends AndroidTestCase {

    ColorInverter colorInverter;

    ColorInverterTest(Class<T> colorInverterClass) {
        try {
            colorInverter = colorInverterClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void testShouldInvertPixels() throws Exception {
        // given
        int width = 16;
        int height = 16;
        int inputColor = Color.argb(255, 0, 128, 255);
        int expectedColor = Color.argb(255, 255, 127, 0);
        int pixels[] = new int[width * height];
        Arrays.fill(pixels, inputColor);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        setPixelsIn(bitmap, pixels);

        // when
        colorInverter.invertColorsIn(bitmap);

        // then
        int retrievedPixels[] = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(retrievedPixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int index = 0; index < pixels.length; ++index) {
            assertThat(retrievedPixels[index]).isEqualTo(expectedColor);
        }
    }

    private void setPixelsIn(Bitmap bitmap, int[] pixels) {
        bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public void testInvertPerformance() throws Exception {
        // given
        int loops = 10;
        int width = 2048;
        int height = 2048;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);

        // when
        for(int index = 0; index < loops; ++index) {
            colorInverter.invertColorsIn(bitmap);
        }
    }
}
