package groovytils.date.parse

/**
 * @author Ruslan Khmelyuk
 * @created 2011-05-19
 */
class DateWithResolution {

    final Date date
    final DateResolution resolution

    DateWithResolution(Date date, DateResolution resolution) {
        this.date = date
        this.resolution = resolution
    }
}
