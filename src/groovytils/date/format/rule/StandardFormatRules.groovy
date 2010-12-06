package groovytils.date.format.rule

import groovytils.date.format.FormatRules

/**
 * Standard format rules.
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class StandardFormatRules extends FormatRules {

    StandardFormatRules() {
        add new SecondsFormatRule()
        add new MinutesFormatRule()
        add new HoursFormatRule()
        add new DaysFormatRule()
        add new MonthsFormatRule()
        add new YearsFormatRule()
    }
}
