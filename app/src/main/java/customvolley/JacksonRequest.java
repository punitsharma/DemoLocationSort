package customvolley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import customvolley.utils.MobConstant;

public abstract class JacksonRequest<T> extends Request<T> {

	/** Charset for request. */
	private static final String PROTOCOL_CHARSET = "utf-8";

	/** Content type for request. */
	private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

	protected Map<String, String> headers;
	protected Listener<T> listener;
	protected boolean cacheHit;
	protected Context context;
	protected String url;
	protected ParseCacheHeaders cacheParser;
	protected String jsonRequest;

	
	/**
	 * Create a new request that is going to return a Object parsed with the
	 * Jackson library.
	 * 
	 * @param ctx
	 *            , Context
	 * @param url
	 *            , The url of the request
	 * @param clazz
	 *            , The class of the object model, this object has to be
	 *            serializable and use Jackson annotations.
	 * @param headers
	 *            , The headers of the request, "Accept-Encoding" is mandatory
	 *            to avoid errors.
	 * @param listener
	 *            , The listener where the response is going to be delivered.
	 * @param errorListener
	 *            , The error listener where the errors are going to be
	 *            delivered.
	 * @param cacheParser
	 *            , set null if you don't want change the default behavior of
	 *            the http cache headers.
	 */
	public JacksonRequest(Context ctx, int method, String url, String jsonRequest, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener,
						  ParseCacheHeaders cacheParser) {
		super(method, url, errorListener);
		this.headers = headers;
		this.listener = listener;
		this.context = ctx;
		this.url = url;
		this.jsonRequest = jsonRequest;
		this.cacheParser = cacheParser;
		setRetryPolicy(new DefaultRetryPolicy(MobConstant.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers != null ? headers : super.getHeaders();
	}

	@Override
	protected abstract Response<T> parseNetworkResponse(NetworkResponse response);

	@Override
	protected void deliverResponse(T response) {
		if (listener != null) {
			listener.onResponse(response);
		}
	}

	@Override
	public void addMarker(String tag) {
		super.addMarker(tag);
		if (tag.equals("network-http-complete")) {
			cacheHit = false;
		}
		if (tag.equals("cache-hit")) {
			cacheHit = true;
		}
	}

	@Override
	public String getBodyContentType() {
		return PROTOCOL_CONTENT_TYPE;
	}

	@Override
	public byte[] getBody() {
		try {
			return jsonRequest == null ? null : jsonRequest.getBytes(PROTOCOL_CHARSET);
		} catch (UnsupportedEncodingException uee) {
			VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", jsonRequest, PROTOCOL_CHARSET);
			return null;
		}
	}

}
