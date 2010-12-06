package groovytils.date.format

/**
 * The tests for {@link PrettyPrint}.
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class PrettyPrintTests extends GroovyTestCase {

    def print = new PrettyPrint()
    def date = new Date()

    void testNull() {
        assertEquals '', print.format(null)
    }

    void testJustNow() {
        date.seconds = date.seconds - 5
        assertEquals 'just now', print.format(date, null, TimeUnit.Seconds)
    }

    void testJustNowByDefault() {
        date.seconds = date.seconds - 5
        assertEquals 'a few moments ago', print.format(date)
    }

    void testPrefix() {
        date.seconds = date.seconds - 5
        print.config.prefix = 'start'
        assertEquals 'start just now', print.format(date, null, TimeUnit.Seconds)
    }

    void testSuffix() {
        date.seconds = date.seconds - 5
        print.config.suffix = 'from now'
        assertEquals 'just now from now', print.format(date, null, TimeUnit.Seconds)
    }

    void testSeconds() {
        date.seconds = date.seconds - 40
        assertEquals 'a few moments ago', print.format(date, null, TimeUnit.Seconds)
    }

    void testMinutes() {
        date.minutes = date.minutes - 1
        assertEquals 'a minute ago', print.format(date)

        date = new Date()
        date.minutes = date.minutes - 2
        assertEquals '2 minutes ago', print.format(date)

        date = new Date()
        date.minutes = date.minutes - 40
        assertEquals '40 minutes ago', print.format(date)
    }

    void testHours() {
        date = new Date()
        date.minutes = date.minutes - 40
        assertEquals 'less than an hour ago', print.format(date, null, TimeUnit.Hours)

        date.hours = date.hours - 1
        assertEquals 'about an hour ago', print.format(date)

        date = new Date()
        date.hours = date.hours - 2
        assertEquals 'about 2 hours ago', print.format(date)

        date = new Date()
        date.hours = date.hours - 10
        assertEquals 'about 10 hours ago', print.format(date)
    }

    void testDays() {
        def today = new Date(110, 11, 8)
        date = new Date(110, 11, 8)
        assertEquals 'today', print.format(date, today, TimeUnit.Days)

        date = new Date()
        date.date = date.date - 1
        assertEquals 'yesterday', print.format(date)

        date = new Date()
        date.date = date.date - 7
        assertEquals 'about a week ago', print.format(date)

        date = new Date()
        date.date = date.date - 14
        assertEquals '2 weeks ago', print.format(date)

        date = new Date(110, 11, 8)
        date.date = date.date - 6
        assertEquals 'last Thursday', print.format(date, today)

        date = new Date(110, 11, 8)
        date.date = date.date - 2
        assertEquals 'this Monday', print.format(date, today)

        date = new Date()
        date.date = date.date - 10
        assertEquals '10 days ago', print.format(date)

        date = new Date(110, 11, 8, 22, 10, 12)
        date.date = date.date - 26
        print.config.showTime = true
        assertEquals '12 November 2010, 22:10', print.format(date, today)
    }

    void testMonths() {
        date = new Date()
        assertEquals 'less than a month ago', print.format(date, null, TimeUnit.Months)

        date.month = date.month - 1
        assertEquals 'about a month ago', print.format(date)

        date = new Date()
        date.month = date.month - 2
        assertEquals 'about 2 months ago', print.format(date)

        date = new Date()
        date.month = date.month - 6
        assertEquals 'a half year ago', print.format(date)
    }

    void testYears() {
        date = new Date()
        assertEquals 'less than a year ago', print.format(date, null, TimeUnit.Years)

        date.year = date.year - 1
        assertEquals 'about a year ago', print.format(date)

        date = new Date()
        date.year = date.year - 2
        assertEquals 'about 2 years ago', print.format(date)
    }

}
