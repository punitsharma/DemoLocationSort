package customvolley;

import android.content.Context;
import android.os.Build;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import javax.net.ssl.SSLContext;

public class MobHttpVolley {

	private static MobHttpVolley instance;
	private RequestQueue mRequestQueue;
	private static Context mCtx;
	private ModelLruCache cache;
	private ImageLoader mImageLoader;
	private static SSLContext mSSLContext;

	private MobHttpVolley(Context ctx, SSLContext sslContext) {
		mCtx = ctx;
		mSSLContext = sslContext;
		mRequestQueue = getRequestQueue();
		cache = new ModelLruCache();
		mImageLoader = new ImageLoader(mRequestQueue, BitmapCache.getInstance(mCtx));
	}

	/**
	 * Method to get access to the singleton instance of the MobHttpValley
	 *
	 * @param ctx  context
	 * @return  MobHttpVolley
	 */
	public static MobHttpVolley getInstance(Context ctx, SSLContext sslContext) {
		if (instance == null) {
			instance = new MobHttpVolley(ctx,sslContext);
		} else {
			if (sslContext != null && mSSLContext == null) {
				mSSLContext = sslContext;
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
					instance.mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(), new OAuthHurlStack(sslContext));
				}
			}
		}
		return instance;
	}

	public static ImageLoader getImageLoader(Context ctx) {
		if (instance == null) {
			instance = new MobHttpVolley(ctx, null);
		}
		return instance.mImageLoader;
	}

	protected RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			// getApplicationContext() is key, it keeps you from leaking the
			// Activity or BroadcastReceiver if someone passes one in.
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
				mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(), new OAuthHurlStack(mSSLContext));
			}
		}
		return mRequestQueue;
	}

	/**
	 * Adds a Request to the dispatch queue.
	 * 
	 * @param req
	 *            The request to service
	 */
	public <T> void addToRequestQueue(Request<T> req) {
		getRequestQueue().add(req);
	}

	/**
	 * Clean HTTP Cache and memory cache.
	 */
	public void cleanCache() {
		getRequestQueue().getCache().clear();
		cache.evictAll();
	}

	ModelLruCache getCache() {
		return cache;
	}

}
