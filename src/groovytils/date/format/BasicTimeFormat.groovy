package groovytils.date.format

import java.text.SimpleDateFormat

/**
 * Basic Date Time Format implementation.
 *
 * @author Ruslan Khmelyuk
 * @created 2010-12-06
 */
class BasicTimeFormat implements TimeFormat {

    String seconds(Date date, int units, PrettyPrintConfig config) {
        if (units < 30) {
            return "just now"
        }
        return "a few moments ago"
    }

    String minutes(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
                return 'a few moments ago'
            case 1:
                return 'a minute ago'
            default:
                return "$units minutes ago"
        }
    }

    String hours(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
                return 'less than an hour ago'
            case 1:
                return 'about an hour ago'
            default:
                return "about $units hours ago"
        }
    }

    String days(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
                return 'today'
            case 1:
                return 'yesterday'
            case 7:
                return 'about a week ago'
            case 14:
                return '2 weeks ago'
            case 21:
                return '3 weeks ago'
            case 28:
                return '4 weeks ago'
            case { it > 28 && it < 31 }:
                return 'about a month ago'
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
                def format = config.dateFormat
                if (config.showTime) {
                    format += ', ' + config.timeFormat
                }
                return new SimpleDateFormat(format).format(date)
        }
    }

    String months(Date date, int units, PrettyPrintConfig config) {
        switch (units) {
            case 0:
                return 'less than a month ago'
            case 1:
                return 'about a month ago'
            case 6:
                return 'a half year ago'
            default:
                return "about $units months ago"
        }
    }

    String years(Date date, int units, PrettyPrintConfig config) {
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
