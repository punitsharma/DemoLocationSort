package customvolley;

import com.android.volley.toolbox.HurlStack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class OAuthHurlStack extends HurlStack {

	private final SSLContext sslContext;

	public OAuthHurlStack(SSLContext sslContext) {
		this.sslContext = sslContext;
	}

	@Override
	protected HttpURLConnection createConnection(URL url) throws IOException {
		HttpURLConnection connection;
		if (sslContext != null) {
			connection = (HttpsURLConnection) url.openConnection();
			((HttpsURLConnection) connection).setSSLSocketFactory(sslContext.getSocketFactory());
		} else {
			connection = (HttpURLConnection) url.openConnection();
		}
		return connection;
	}
}