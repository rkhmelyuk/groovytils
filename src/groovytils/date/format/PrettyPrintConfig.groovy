package groovytils.date.format

/**
 * The configuration for {@link PrettyPrint}
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class PrettyPrintConfig {

    TimePrecision timePrecision = TimePrecision.Minutes

    boolean showTime = false
    String timeFormat = 'HH:mm'
    String dateFormat = 'd MMMMM yyyy'

    String suffix
    String prefix

}
