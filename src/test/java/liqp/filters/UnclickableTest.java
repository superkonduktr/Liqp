package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnclickableTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ 'something' | unclickable }}", "something"},
                {"{{ 42 | unclickable }}", "42"},
                {"{{ 'http://example.com' | unclickable }}", "http<span>:</span>//example<span>.com</span>"},
                {"{{ 'www.example.com?hello=world' | unclickable }}", "<span>www.</span>example<span>.com</span>?hello=world"},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
