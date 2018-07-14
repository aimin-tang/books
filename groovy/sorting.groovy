List strings = 'this is a list of strings'.split()
println strings

Collections.sort(strings)
println(strings)

Collections.sort(strings, new Comparator<String>() {
    int compare(String s1, String s2) {
        s1.size() <=> s2.size()
    }
})

println(strings)
assert strings*.size() == [1, 2, 2, 4, 4, 7]

println strings.sort(false)

println strings.sort(false, new Comparator<String>() {
    int compare(String s1, String s2) {
        s1.size() <=> s2.size()
    }
})

println strings.sort(false) { s1, s2 ->
    s2.size() <=> s1.size()
}

println strings.sort(false) { it.size()}

println strings.sort(false) {String s1, String s2 ->
    s1.size() <=> s2.size() ?: s2 <=> s1
}