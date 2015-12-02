package customvolley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import customvolley.utils.MobConstant;

public class MobRequest extends StringRequest {

	private final Map<String, String> headers;

	/**
	 * Creates a new request with the given method.
	 * 
	 * 
	 * @param ctx
	 *            , Context
	 * @param url
	 *            , The url of the request
	 * @param method
	 *            , The http method to use.
	 * @param headers
	 *            , The headers of the request, "Accept-Encoding" is mandatory
	 *            to avoid errors.
	 * @param listener
	 *            , The listener where the response is going to be delivered.
	 * @param errorListener
	 *            , The error listener where the errors are going to be
	 *            delivered.
	 */
	public MobRequest(Context ctx, String url, int method, Map<String, String> headers, Listener<String> listener, ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		this.headers = headers;
		setRetryPolicy(new DefaultRetryPolicy(MobConstant.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers != null ? headers : super.getHeaders();
	}

}
