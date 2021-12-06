package pgdp.color;

/**
 * Vorgegebene Klasse, hier drin wird nichts bewertet !!!
 * <p>
 * Bitte nicht verändern !!
 */
public class IntMath {
    private IntMath() {

    }

    public static int powerOfTwo(int exponent) {
        if (exponent > 31)
            ExceptionUtil.unsupportedOperation("exponent too large: " + exponent);
        if (exponent < 0)
            ExceptionUtil.unsupportedOperation("exponent cannot be negative: " + exponent);
        return 1 << exponent;
    }
}
