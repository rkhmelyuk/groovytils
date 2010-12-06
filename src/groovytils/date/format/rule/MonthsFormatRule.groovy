package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class MonthsFormatRule implements FormatRule {

    boolean supports(int units) {
        true
    }

    int inSeconds() {
        3600 * 24 * 30
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
               return 'less than a month ago'
            case 1:
               return 'a months ago'
            case 6:
               return 'a half year ago'
            default:
                return "about $units months ago"
        }
    }

}
