package groovytils.file

/**
 * @author Ruslan Khmelyuk
 * @created 2011-06-28
 */
class FileScanner {

    private final String root

    FileScanner(String root) {
        this.root = root
    }

    def find(String name, Closure action) {
        def dir = new File(root)
        if (dir.exists() && dir.directory) {
            boolean done = false
            dir.eachFileRecurse { File file ->
                if (!done && file.file && file.name == name) {
                    action.call(file)
                    done = true
                }
            }
        }
    }

    def each(Closure action) {
        def dir = new File(root)
        if (dir.exists() && dir.directory) {
            dir.eachFileRecurse{ File file ->
                if (file.file) {
                    action.call(file)
                }
            }
        }
    }
}
