package liqp.filters;

import java.util.Arrays;

class Limit extends Filter {

    /*
     * limit(array, n)
     *
     * Take the first n elements of an array
     */
    @Override
    public Object apply(Object value, Object... params) {

        if (value == null) {
            return "";
        }

        Object[] input = super.asArray(value);
        int inputLength = input.length;
        int limit;

        if (params.length > 0) {
            int inputLimit = super.asNumber(params[0]).intValue();
            if (inputLimit > inputLength) {
                limit = inputLength;
            } else {
                limit = inputLimit;
            }
        } else {
            limit = inputLength;
        }

        return Arrays.copyOfRange(input, 0, limit);
    }
}
