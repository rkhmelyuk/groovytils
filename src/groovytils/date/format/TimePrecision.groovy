package groovytils.date.format

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
enum TimePrecision {

    Seconds(1, 60),
    Minutes(60, 60),
    Hours(Minutes.seconds * 60, 24),
    Days(Hours.seconds * 24, 30),
    Months(Days.seconds * 30, 12),
    Years(Days.seconds * 365, 1000)

    final int seconds
    final int maxUnits

    TimePrecision(int seconds, int maxUnits) {
        this.seconds = seconds
        this.maxUnits = maxUnits
    }

    int getMaxSeconds() {
        seconds * maxUnits - 1
    }

    static TimePrecision last() {
        Years
    }
}
