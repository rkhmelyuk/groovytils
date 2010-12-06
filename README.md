Copyright (c) 2010 Ruslan Khmelyuk

Groovy Utils
------------

### PrettyPrint

Used to build past date representation as it used in Twitter for messages and GitHub for commits.
For example:

    import groovytils.date.format.PrettyPrint

    def print = new PrettyPrint()

    def date = new Date()
    date -= 2
    assertEquals 'about 2 days ago', print.format()

    date = new Date()
    date.seconds -= 10
    assertEquals 'a few moments ago', print.format(date)

    date = new Date()
    date.minutes -= 30
    assertEquals '30 minutes ago', print.format(date)

`PrettyPrint` has 3 constructors:

* without any parameter - constructs object with `BasicTimeFormat` and `PrettyPrintConfig` with default values.
* with only 1 parameter - `BasicTimeFormat`
* with 2 parameters - `BasicTimeFormat` and `PrettyPrintConfig`

### TimeFormat

Formatting can be extended with implementing `groovytils.date.format.TimeFormat` interface.
There are 2 out-of-box implementations:

* `BasicTimeFormat` - used be default by `PrettyPrint`, tries to be as general as possible.
* `DetailTimeFormat` - tries to be as specified as possible.
