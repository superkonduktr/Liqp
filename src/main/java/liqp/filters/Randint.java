package liqp.filters;

import java.util.Random;

class Randint extends Filter {

    /*
     * (Object) random(int)
     * (Object) random(int, int)
     *
     * Random integer within given interval
     */
    @Override
    public Object apply(Object value, Object... params) {

        if (!super.isNumber(value)) {
            return 0;
        }

        int max = super.asNumber(value).intValue();

        if (max < 1) {
            return 0;
        }

        int min;

        if (params.length == 0) {
            min = 0;
        } else {
            min = super.asNumber(params[0]).intValue();
        }

        Random r = new Random();

        return r.nextInt(max - min + 1) + min;
    }
}
