package Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonIO {
     public <T> T JsonString_to_Object(String JSON_string,Class<T> objectClass ) throws JsonProcessingException {
        System.out.println(objectClass.getClass());
        T newObject = new ObjectMapper().readValue(JSON_string,objectClass);
        return newObject;
    }
     public String Object_to_JsonString(Object object) throws JsonProcessingException {
        String newJsonString = new ObjectMapper().writeValueAsString(object);
        return newJsonString;
    }
}
