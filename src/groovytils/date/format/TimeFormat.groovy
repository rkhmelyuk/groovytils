package groovytils.date.format

/**
 * Format the date.
 *
 * @author Ruslan Khmelyuk
 * @created 2010-12-06
 */
interface TimeFormat {

    String seconds(Date date, int units, PrettyPrintConfig config)

    String minutes(Date date, int units, PrettyPrintConfig config)

    String hours(Date date, int units, PrettyPrintConfig config)

    String days(Date date, int units, PrettyPrintConfig config)

    String months(Date date, int units, PrettyPrintConfig config)

    String years(Date date, int units, PrettyPrintConfig config)
}
