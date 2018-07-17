'http://oreilly.com'.toURL().text.eachLine {println it}
'http://oreilly.com'.toURL().eachLine {println it}

println 'http://oreilly.com'.toURL().readLines()*.size()
assert 'http://oreilly.com'.toURL().readLines()*.size() ==
        'http://oreilly.com'.toURL().text.readLines()*.size()