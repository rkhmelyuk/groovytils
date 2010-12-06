package groovytils.date.format

/**
 * @author Ruslan Khmelyuk
 * @created 2010-12-06
 */
class DetailTimeFormatTests extends GroovyTestCase {

    def date = new Date()
    def print = new PrettyPrint(new DetailTimeFormat())

    void testSeconds() {
        date.seconds = date.seconds - 40
        assertEquals '40 seconds ago', print.format(date, null, TimeUnit.Seconds)
    }

    void testMinutes() {
        assertEquals 'a minute ago', print.format(date)

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
        assertEquals 'about an hour ago', print.format(date, null, TimeUnit.Hours)

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
        assertEquals '8 December 2010', print.format(date, today, TimeUnit.Days)

        date = new Date(110, 11, 7)
        assertEquals '7 December 2010', print.format(date, today)

        date = new Date(110, 11, 1)
        assertEquals '1 December 2010', print.format(date, today)

        date = new Date(110, 11, 2)
        assertEquals '2 December 2010', print.format(date, today)

        date = new Date(110, 11, 8, 22, 10, 12)
        date.date = date.date - 26
        print.config.showTime = true
        assertEquals '12 November 2010, 22:10', print.format(date, today)
    }

    void testMonths() {
        date = new Date(110, 11, 8)
        date.date = date.date - 6
        assertEquals '2 December 2010', print.format(date)
    }

    void testYears() {
        date = new Date(110, 11, 8)
        date.year = date.year - 6
        assertEquals '8 December 2004', print.format(date)
    }

}
