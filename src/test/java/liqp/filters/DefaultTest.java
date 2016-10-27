package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefaultTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ 42 | default: 'something' }}", "42"},
                {"{{ '' | default: 'something' }}", ""},
                {"{{ null | default: 'something' }}", "something"}
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
