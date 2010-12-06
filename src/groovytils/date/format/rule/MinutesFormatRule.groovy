package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class MinutesFormatRule implements FormatRule {

    boolean supports(int units) {
        units < 3600
    }

    int inSeconds() {
        60
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
               return 'less than a minute ago'
            case 1:
               return 'a minute ago'
            default:
                return "$units minutes ago"
        }
    }

}
