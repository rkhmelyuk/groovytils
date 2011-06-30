package groovytils.date.parse

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Use to parse dates of different format entered by users.
 *
 * @author Ruslan Khmelyuk
 * @created 2011-01-28
 */
class DateParser {

    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");

    private static final Map<String, DateResolution> DATE_FORMATS_SLASH = new LinkedHashMap<String, DateResolution>()
    private static final Map<String, DateResolution> DATE_FORMATS_SPACE = new LinkedHashMap<String, DateResolution>()
    private static final Map<String, DateResolution> DATE_FORMATS_DASH = new LinkedHashMap<String, DateResolution>()
    private static final Map<String, DateResolution> DATE_FORMATS_QUOTE = new LinkedHashMap<String, DateResolution>()
    private static final Map<String, DateResolution> DATE_FORMATS = new LinkedHashMap<String, DateResolution>()

    static {
        DATE_FORMATS_SLASH['dd/MM/yyyy'] = DateResolution.Day
        DATE_FORMATS_SLASH['d/MM/yyyy'] = DateResolution.Day
        DATE_FORMATS_SLASH['dd/MM/yy'] = DateResolution.Day
        DATE_FORMATS_SLASH['d/MM/yy'] = DateResolution.Day
        DATE_FORMATS_SLASH['dd/MMM/yyyy'] = DateResolution.Day
        DATE_FORMATS_SLASH['d/MMM/yyyy'] = DateResolution.Day
        DATE_FORMATS_SLASH['MM/yyyy'] = DateResolution.Month
        DATE_FORMATS_SLASH['MMM/yyyy'] = DateResolution.Month
        DATE_FORMATS_SLASH['MM/yy'] = DateResolution.Month

        DATE_FORMATS_DASH['d-MM-yyyy'] = DateResolution.Day
        DATE_FORMATS_DASH['dd-MM-yyyy'] = DateResolution.Day
        DATE_FORMATS_DASH['d-MMM-yyyy'] = DateResolution.Day
        DATE_FORMATS_DASH['dd-MMM-yyyy'] = DateResolution.Day
        DATE_FORMATS_DASH['MMM-yyyy'] = DateResolution.Month
        DATE_FORMATS_DASH['yyyy-MM-dd'] = DateResolution.Day

        DATE_FORMATS_SPACE['d MMMMM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['dd MMMMM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['d MM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['dd MM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['d MMM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['dd MMM yyyy'] = DateResolution.Day
        DATE_FORMATS_SPACE['MMM yyyy'] = DateResolution.Month
        DATE_FORMATS_SPACE['MMMMM yyyy'] = DateResolution.Month

        DATE_FORMATS_QUOTE["MM''yyyy"] = DateResolution.Month
        DATE_FORMATS_QUOTE["MMM''yy"] = DateResolution.Month
        DATE_FORMATS_QUOTE["MMM''yyyy"] = DateResolution.Month
        DATE_FORMATS_QUOTE["MMMMM''yyyy"] = DateResolution.Month

        DATE_FORMATS['yy'] = DateResolution.Year
        DATE_FORMATS['yyyy'] = DateResolution.Year
    }

    /**
     * Parse input date.
     * @param date the date to parse.
     * @param expectedFormat the expected format, optional and not used if null.
     * @return the parsed date or null.
     */
    static Date parseDate(String date, String expectedFormat = null) {
        if (!date) {
            return null
        }

        date = date.trim()

        if (expectedFormat) {
            return parse(date, expectedFormat)
        }

        return _parseWithResolution(date)?.date
    }

    /**
     * Parse input date and finds it's date resolution.
     * Return result as pair.
     *
     * @param date the date to parse.
     * @return the parsed date and appropriate resolution or null.
     */
    static DateWithResolution parseDateWithResolution(String date) {
        if (!date) return null
        return _parseWithResolution(date.trim())
    }

    private static DateWithResolution _parseWithResolution(String date) {
        final def formats
        if (date.contains('-')) {
            formats = DATE_FORMATS_DASH
        }
        else if (date.contains(' ')) {
            formats = DATE_FORMATS_SPACE
        }
        else if (date.contains('/')) {
            formats = DATE_FORMATS_SLASH
        }
        else if (date.contains("'")) {
            formats = DATE_FORMATS_QUOTE
        }
        else {
            formats = DATE_FORMATS
        }

        for (Map.Entry<String, DateResolution> entry in formats.entrySet()) {
            def result = parse(date, entry.key)
            if (result) {
                return new DateWithResolution(result, entry.value)
            }
        }

        return null
    }

    private static Date parse(String value, String pattern) {
        try {
            def format = new SimpleDateFormat(pattern);
            format.setTimeZone(GMT)
            return format.parse(value)
        }
        catch (ParseException e) {
            return null
        }
    }

}
