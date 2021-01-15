package example.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonIO {
     public <T> T JsonString_to_Object(String JSON_string,Class<T> objectClass ) throws JsonProcessingException {
        return new ObjectMapper().readValue(JSON_string,objectClass);
    }
     public String Object_to_JsonString(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
