package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SumTest {

    @Test
    public void applyTest() throws RecognitionException {

        String json = "{ \"array\" : [\"1\", 2, 3.0, \"test\"] }"; 

        String[][] tests = {
                {"{{ '' | sum }}", "0.0"},
                {"{{ '[]' | sum }}", "0.0"},
                {"{{ array | sum }}", "6.0"},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render(json));

            assertThat(rendered, is(test[1]));
        }
    }
}
