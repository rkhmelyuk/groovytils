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

    void testJustNow() {
        date.seconds = date.seconds - 5
        assertEquals 'just now', print.format(date, null, TimePrecision.Seconds)
    }

    void testSeconds() {
        date.seconds = date.seconds - 40
        assertEquals 'less than a minute ago', print.format(date, null, TimePrecision.Seconds)
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
        assertEquals 'less than an hour ago', print.format(date, null, TimePrecision.Hours)

        date.hours = date.hours - 1
        assertEquals 'an hour ago', print.format(date)

        date = new Date()
        date.hours = date.hours - 2
        assertEquals '2 hours ago', print.format(date)

        date = new Date()
        date.hours = date.hours - 10
        assertEquals '10 hours ago', print.format(date)
    }

    void testDays() {
        def today = new Date(110, 11, 8)
        date = new Date(110, 11, 8)
        assertEquals 'today', print.format(date, today, TimePrecision.Days)

        date = new Date()
        date.date = date.date - 1
        assertEquals 'yesterday', print.format(date)

        date = new Date()
        date.date = date.date - 7
        assertEquals 'week ago', print.format(date)

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

        date = new Date(110, 11, 8)
        date.date = date.date - 26
        assertEquals '12 November 2010', print.format(date, today)
    }

}
