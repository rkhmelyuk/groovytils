package groovytils.date.format

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
enum TimePrecision {

    Seconds(1),
    Minutes(60),
    Hours(Minutes.seconds * 60),
    Days(Hours.seconds * 24),
    Weeks(Days.seconds * 7),
    Months(Days.seconds * 30),
    Years(Days.seconds * 365)

    final int seconds

    TimePrecision(int seconds) {
        this.seconds = seconds
    }
}
