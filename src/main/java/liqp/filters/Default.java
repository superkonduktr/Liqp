package liqp.filters;

class Default extends Filter {

    /*
     * default(input, fallback)
     *
     * Evaluates to fallback if input is null.
     */
    @Override
    public Object apply(Object value, Object... params) {
        if (value == null) {
          return params[0];
        } else {
          return value;
        }
    }
}
