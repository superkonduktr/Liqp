package liqp.filters;

class Unclickable extends Filter {

    /*
     * unclickable(input)
     *
     * Inserts <span> inbetween url parts to deceive email clients into seeing it as plain text.
     */
    @Override
    public Object apply(Object value, Object... params) {
        String original = super.asString(value);

        String result = original.
            replaceAll(":", "<span>:</span>").
            replaceAll("www.", "<span>www.</span>").
            replaceAll("\\.(com|es|kz|net|org|ru|tr|ua|uk|рф)", "<span>.$1</span>");

        return result;
    }
}
