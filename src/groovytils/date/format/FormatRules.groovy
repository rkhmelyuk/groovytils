package groovytils.date.format

/**
 * Used to provide messages formats.
 * 
 * @author Ruslan Khmelyuk
 * @created 2010-12-05
 */
class FormatRules {

    final List<FormatRule> rules = []

    void add(FormatRule rule) {
        if (rule) {
            rules.add rule
        }
    }

}
