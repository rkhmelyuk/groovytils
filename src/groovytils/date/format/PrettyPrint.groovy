package groovytils.date.format

import groovytils.date.format.rule.StandardFormatRules
import java.text.SimpleDateFormat

/**
 * Pretty prints date.
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class PrettyPrint {

    FormatRules formatRules
    PrettyPrintConfig config

    PrettyPrint() {
        this(new StandardFormatRules(), new PrettyPrintConfig())
    }

    PrettyPrint(FormatRules formatRules) {
        this(formatRules, new PrettyPrintConfig())
    }

    PrettyPrint(FormatRules formatRules, PrettyPrintConfig config) {
        this.config = config
        this.formatRules = formatRules
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

        for (FormatRule rule in formatRules.rules) {
            if (rule.inSeconds() >= precision.seconds) {
                if (rule.supports(diff)) {
                    int units = diff.intdiv(rule.inSeconds())
                    return rule.format(date, units, config)
                }
            }
        }

        return new SimpleDateFormat(config.dateFormat).format(date)
    }
}
