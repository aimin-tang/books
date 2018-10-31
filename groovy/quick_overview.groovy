def x = 1
println x.class.name
x = 'abc'
println x.class.name
x = new Date()
println x.class.name

List nums = [3, 1, 4, 1, 5, 9]
println nums.class.name

def map = [a:1, b:2, c:2]
println map
println map.keySet()
println map.entrySet()
println map.values()
map.d = 3
map['e'] = 2
map.put('f', 1)

List strings = 'This is a list of strings'.split()
strings.each {
    println it
}

strings.eachWithIndex{ s, idx ->
    println("strings[$idx] == $s")
}

boolean isPalindrome(String s) {
    String test = s.toLowerCase().replaceAll(/\W/, '')
    test == test.reverse()
}

import groovy.transform.*
@Canonical
class Person {
    String first
    String last
}
Person p1 = new Person(first: 'Larry', last: 'Bird')
Person p2 = new Person(first: 'Larry', last: 'Bird')
Person p3 = new Person('Larry', 'Bird')
Set people = [p1, p2, p3]
println people
println people*.first
println people.collect { "${it.first} ${it.last}" }
              .findAll { it.size() > 10}
              .join(',')
