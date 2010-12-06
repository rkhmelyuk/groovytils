package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class YearsFormatRule implements FormatRule {

    boolean supports(int units) {
        true
    }

    int inSeconds() {
        3600 * 24 * 365
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
               return 'less than a year ago'
            case 1:
               return 'about a year ago'
            default:
                return "about $units years ago"
        }
    }

}
