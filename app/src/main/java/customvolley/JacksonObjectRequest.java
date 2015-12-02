package customvolley;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

public class JacksonObjectRequest<T> extends JacksonRequest<T> {

	/** Charset for request. */
	private static final String PROTOCOL_CHARSET = "utf-8";

	/** Content type for request. */
	private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

	private final Class<T> clazz;

	public JacksonObjectRequest(Context ctx, String url, Class<T> clazz, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener,
								ParseCacheHeaders cacheParser) {
		this(ctx, url, null, clazz, headers, listener, errorListener, cacheParser);
	}

	public JacksonObjectRequest(Context ctx, String url, String jsonRequest, Class<T> clazz, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener,
								ParseCacheHeaders cacheParser) {
		super(ctx, Method.GET, url, jsonRequest, headers, listener, errorListener, cacheParser);
		this.clazz = clazz;
	}

	public JacksonObjectRequest(Context ctx, String url, Class<T> clazz, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener) {
		super(ctx, Method.GET, url, null, headers, listener, errorListener, null);
		this.clazz = clazz;
	}

	public JacksonObjectRequest(Context ctx, String url, String jsonRequest, Class<T> clazz, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener) {
		super(ctx, Method.GET, url, jsonRequest, headers, listener, errorListener, null);
		this.clazz = clazz;
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		Cache.Entry cacheEntry = null;
		if (cacheParser != null) {
			cacheEntry = cacheParser.parseCacheHeaders(response);
		} else {
			cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
		}
		if (cacheHit && MobHttpVolley.getInstance(context, null).getCache().get(url) != null) {
			return (Response<T>) Response.success(MobHttpVolley.getInstance(context, null).getCache().get(url), cacheEntry);
		} else {
			try {
				T object = JsonUtils.parseJson(new ByteArrayInputStream(response.data), clazz);
				MobHttpVolley.getInstance(context, null).getCache().put(url, object);
				return Response.success(object, cacheEntry);
			} catch (JsonParseException e) {
				return Response.error(new ParseError(e));
			} catch (JsonMappingException e) {
				return Response.error(new ParseError(e));
			} catch (IOException e) {
				return Response.error(new ParseError(e));
			}
		}

	}

}
