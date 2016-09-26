package liqp.filters;

import java.util.ArrayList;

class Sum extends Filter {

    /*
     * sum(input)
     *
     * Attempts to sum numeric elements of input
     */
    @Override
    public Object apply(Object value, Object... params) {

        double result = 0D;

        if (value == null) {
            return result;
        }

        Object[] array = super.asArray(value);

        for (Object obj : array) {
            if (super.isNumber(obj)) {
                result += super.asNumber(obj).doubleValue();
            }
        }

        return result;
    }
}
