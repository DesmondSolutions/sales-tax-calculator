package salestaxapplication.util;

/**
 * Utility class for rounding up tax values
 */
public class TaxUtils {

    /**
     * Rounds the value. Standard roundup format.
     *
     * @param value The value to round up.
     * @return The rounded up value.
     */
    public static double totalAmountRoundup(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Rounds the value to the nearest 0.05
     * Used for rounding up sales tax values
     *
     * @param value The value to round up
     * @return The rounded value
     */
    public static double taxRoundup(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }
}
