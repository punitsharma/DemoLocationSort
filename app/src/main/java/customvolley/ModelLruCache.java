package customvolley;

import android.support.v4.util.LruCache;


public class ModelLruCache extends LruCache<String, Object> {
	public static int getDefaultLruCacheSize() {
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		final int cacheSize = maxMemory / 16;
		return cacheSize;
	}

	public ModelLruCache() {
		this(getDefaultLruCacheSize());
	}

	public ModelLruCache(int sizeInKiloBytes) {
		super(sizeInKiloBytes);
	}

	// @Override
	// protected int sizeOf(String key, Object value) {
	// try {
	// return (int) (sizeOf(value)/1024);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return 0;
	// }
	
	
//	 private final long sizeOf(Object object) throws IOException {
//		    
//		    if (object == null)
//		      return 0;
//		    
//		    // Special output stream use to write the content
//		    // of an output stream to an internal byte array.
//		    ByteArrayOutputStream byteArrayOutputStream =
//		      new ByteArrayOutputStream();
//		    
//		    // Output stream that can write object
//		    ObjectOutputStream objectOutputStream =
//		      new ObjectOutputStream(byteArrayOutputStream);
//		    
//		    // Write object and close the output stream
//		    objectOutputStream.writeObject(object);
//		    objectOutputStream.flush();
//		    objectOutputStream.close();
//		    
//		    // Get the byte array
//		    byte[] byteArray = byteArrayOutputStream.toByteArray();
//		    
//		    return byteArray == null ? 0 : byteArray.length;
//		    
//		  }

}