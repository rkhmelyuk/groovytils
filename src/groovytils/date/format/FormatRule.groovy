package groovytils.date.format

import groovytils.date.format.PrettyPrintConfig

/**
 * The rule used to format the time.
 *
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
interface FormatRule {

    /**
     * Whether rule can be used to print specified values.
     * @param units the time in units.
     * @return true if rule can be used to format time.
     */
    boolean supports(int units)

    /**
     * The rule time in seconds, used to convert into units.
     * @return the rule time in seconds.
     */
    int inSeconds()

    /**
     * Format the date.
     *
     * @param units the date as units.
     * @param config the pretty print config.
     * @return the formatted string.
     */
    String format(Date date, int units, PrettyPrintConfig config)
}
