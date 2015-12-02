package customvolley;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtils {
	public static <T> T parseJson(InputStream node, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return JsonUtils.getObjectMapper().readValue(node, clazz);
	}

	public static <T> T parseJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return JsonUtils.getObjectMapper().readValue(json, clazz);
	}

	public static List<?> parseJsonList(InputStream node, TypeReference<List<?>> typeReference) throws JsonParseException, JsonMappingException, IOException {
		return JsonUtils.getObjectMapper().readValue(node, typeReference);
	}

	private static ObjectMapper objectMapper;

	public static ObjectMapper getObjectMapper() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
	        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
	        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		}

		return objectMapper;
	}
}
