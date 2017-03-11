package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LimitTest {

    @Test
    public void applyTest() throws RecognitionException {

        Template template = Template.parse("{{ values | limit: 3 }}");
        String rendered = String.valueOf(template.render("{\"values\" : [\"a\", \"b\", \"c\", \"d\"]}"));
        assertThat(rendered, is("abc"));
    }
}
