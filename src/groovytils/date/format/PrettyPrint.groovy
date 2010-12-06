package groovytils.date.format

import java.text.SimpleDateFormat

/**
 * Pretty prints date.
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class PrettyPrint {

    final TimeFormat format
    final PrettyPrintConfig config

    PrettyPrint() {
        this(new BasicTimeFormat(), new PrettyPrintConfig())
    }

    PrettyPrint(TimeFormat format) {
        this(format, new PrettyPrintConfig())
    }

    PrettyPrint(TimeFormat format, PrettyPrintConfig config) {
        this.config = config
        this.format = format
    }

    String format(Date date, Date from = null, TimePrecision precision = null) {
        if (!date) {
            return ''
        }

        // default values
        precision = precision ?: config.timePrecision
        from = from ?: new Date()

        // find difference in seconds
        int diff = (from.time - date.time).intdiv(1000)

        def precisions = (precision..TimePrecision.last())
        def last = precision
        for (TimePrecision each : precisions) {
            if (diff <= each.maxSeconds) {
                last = each
                break
            }
        }

        def result = null

        int units = diff.intdiv(last.seconds)
        switch (last) {
            case TimePrecision.Seconds:
                result = format.seconds(date, units, config)
                break
            case TimePrecision.Minutes:
                result = format.minutes(date, units, config)
                break
            case TimePrecision.Hours:
                result = format.hours(date, units, config)
                break
            case TimePrecision.Days:
                result = format.days(date, units, config)
                break
            case TimePrecision.Months:
                result = format.months(date, units, config)
                break
            case TimePrecision.Years:
                result = format.years(date, units, config)
                break
            default:
                result = new SimpleDateFormat(config.dateFormat).format(date)
        }

        if (config.prefix) {
            result = "$config.prefix $result"
        }
        if (config.suffix) {
            result = "$result $config.suffix"
        }

        return result
    }
}
