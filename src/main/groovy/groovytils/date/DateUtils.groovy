package groovytils.date

import groovytils.date.format.PrettyPrint
import groovytils.date.format.TimeUnit

/**
 * Category for {@link Date} class.
 *
 * @author Ruslan Khmelyuk
 * @created 2010-12-07
 */
class DateUtils {

    static def prettyPrint = new PrettyPrint()

    static String prettyPrint(Date self, TimeUnit unit = null) {
        prettyPrint.format(self, null, unit)
    }

    static String prettyPrintFrom(Date self, Date from, TimeUnit unit = null) {
        prettyPrint.format(self, from, unit)
    }

}
