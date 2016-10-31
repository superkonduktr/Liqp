package liqp.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

class Json extends Filter {

    /*
     * json(obj)
     *
     * Returns given object as a json string
     */
    @Override
    public Object apply(Object value, Object... params) {
        ObjectMapper mapper = new ObjectMapper();

        String res = "";
        try {
            res = mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error applying json filter", e);
        }

        return res;
    }
}
