package customvolley;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;

public interface ParseCacheHeaders {
	Cache.Entry parseCacheHeaders(NetworkResponse response);
}
