package groovytils.date.format

import groovytils.date.parse.DateParser

/**
 * @author Ruslan Khmelyuk
 * @created 2011-05-19
 */
class DateResolutionTests extends GroovyTestCase {

    // TODO - add more tests

    void testCanNotParse() {
        assertNull DateParser.parseDateWithResolution("abra")
    }
}
