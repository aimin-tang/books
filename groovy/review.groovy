List strings = 'this is a list of strings'.split()

strings.eachWithIndex {s, idx ->
    println "string[$idx] == $s"
}

boolean isPalindrome(String s) {
    String test = s.toLowerCase().replaceAll(/\W/, '')
    test == test.reverse()
}

println isPalindrome('Flee to me, remote elf!')

import groovy.transform.*

@Canonical
class Person {
    String first
    String last
}

Person p1 = new Person(first: 'Larry', last: 'Bird')
Person p2 = new Person(first: 'Kevin', last: 'McHale')
Person p3 = new Person('Robert', 'Parrish')
List people = [p1, p2, p3]
println people*.first