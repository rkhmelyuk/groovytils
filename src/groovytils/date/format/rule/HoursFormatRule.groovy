package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class HoursFormatRule implements FormatRule {

    boolean supports(int units) {
        units < 3600 * 24
    }

    int inSeconds() {
        3600
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
               return 'less than an hour ago'
            case 1:
               return 'an hour ago'
            default:
                return "$units hours ago"
        }
    }

}
