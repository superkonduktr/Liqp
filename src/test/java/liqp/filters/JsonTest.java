package liqp.filters;

import java.util.HashMap;
import java.util.Map;
import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JsonTest {

    @Test
    public void applyTest() throws RecognitionException {

        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, String> value = new HashMap<String, String>();

        value.put("tralala", "olala");
        data.put("x", value);

        String[][] tests = {
                {"{{ x | json }}", "{\"tralala\":\"olala\"}"},
                {"{{ 3 | json }}", "3"},
                {"{{ \"a string\" | json }}", "\"a string\"" }
            }
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render(data));

            assertThat(rendered, is(test[1]));
        }
    }
}
