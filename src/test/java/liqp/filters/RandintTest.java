package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandintTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ wut | randint }}", "0"},
                {"{{ 0 | randint }}", "0"},
                {"{{ 6 | randint: 6 }}", "6"},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
