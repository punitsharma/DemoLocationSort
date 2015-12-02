package customvolley;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> mMemoryCache;

	private static BitmapCache mInstance;

	private BitmapCache(Context ctx) {
		final int memClass = ((ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		// Use 1/16th of the available memory for this memory cache.
		final int cacheSize = 1024 * 1024 * memClass / 16;
		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	public static BitmapCache getInstance(Context ctx) {
		if (mInstance == null) {
			mInstance = new BitmapCache(ctx);
		}
		return mInstance;
	}

	@Override
	public Bitmap getBitmap(String url) {
		return mMemoryCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mMemoryCache.put(url, bitmap);
	}
}