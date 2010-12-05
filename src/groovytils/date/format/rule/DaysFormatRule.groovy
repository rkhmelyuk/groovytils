package groovytils.date.format.rule

import groovytils.date.format.FormatRule
import groovytils.date.format.PrettyPrintConfig
import java.text.SimpleDateFormat

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class DaysFormatRule implements FormatRule {

    boolean supports(int units) {
        units < 3600 * 24 * 31
    }

    int inSeconds() {
        3600 * 24
    }

    String format(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
                return 'today'
            case 1:
                return 'yesterday'
            case 7:
                return 'week ago'
            case 14:
                return '2 weeks ago'
            case 21:
                return '3 weeks ago'
            case 28:
                return '4 weeks ago'
            case { it < 7 }:
                def message = new SimpleDateFormat('EEEEE').format(date)
                if (date.day > (date + units).day) {
                    message = 'last ' + message
                }
                else {
                    message = 'this ' + message
                }
                return message
            case { it > 7 && it < 14 }:
                return "$units days ago"
            default:
                return new SimpleDateFormat(config.getDateFormat()).format(date)
        }
    }

}
