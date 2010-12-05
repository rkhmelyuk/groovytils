package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class SecondsFormatRule implements FormatRule {

    boolean supports(int units) {
        units < 60
    }

    int inSeconds() {
        1
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        if (units < 30) {
            return "just now"
        }
        return "less than a minute ago"
    }

}
