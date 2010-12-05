package groovytils.date.format

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
enum TimePrecision {

    Seconds(1),
    Minutes(60),
    Hours(3600),
    Days(3600 * 24),
    Weeks(3600 * 24 * 7),
    Months(3600 * 24 * 30)

    final int seconds

    TimePrecision(int seconds) {
        this.seconds = seconds
    }
}
