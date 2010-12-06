package groovytils.date.format

import java.text.SimpleDateFormat

/**
 * Basic Date Time Format implementation.
 *
 * @author Ruslan Khmelyuk
 * @created 2010-12-06
 */
class DetailTimeFormat implements TimeFormat {

    String seconds(Date date, int units, PrettyPrintConfig config) {
        if (units > 1) {
            return "$units seconds ago"
        }
        return 'a second ago'
    }

    String minutes(Date date, int units, PrettyPrintConfig config) {
        if (units > 1) {
            return "$units minutes ago"
        }
        return "a minute ago"
    }

    String hours(Date date, int units, PrettyPrintConfig config) {
        if (units > 1) {
            return "about $units hours ago"
        }
        return 'about an hour ago'
    }

    String days(Date date, int units, PrettyPrintConfig config) {
        def format = config.dateFormat
        if (config.showTime) {
            format += ', ' + config.timeFormat
        }
        return new SimpleDateFormat(format).format(date)
    }

    String months(Date date, int units, PrettyPrintConfig config) {
        days date, units, config
    }

    String years(Date date, int units, PrettyPrintConfig config) {
        days date, units, config
    }
}
