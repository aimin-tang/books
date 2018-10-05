Range r = 1..<10
println r
println r.contains(1)

def nums = [3, 1, 4]
println nums[1..2]

def map = [a:1, b:2, c:2]
println map.class
map.f = 3
println map

def nums2 = [3, 1, 4] as Set
println nums2

List strings = "this is a list of strings".split()
println strings.class.name

for (int i=0; i<nums.size(); i++) {
    println nums[i]
}

for (n in nums) {
    println n
}

List nums3 = [3, 1, 4, 1, 5, 9]
nums3.each { n -> println n }
nums3.eachWithIndex{ n, idx -> println "nums[$idx] = $n" }

Map m = [a: 1, b: 2, c: 2]
for (String key: m.keySet()) {
    def val = m[key]
    println "map[$key] = $val"
}
m.each { e ->
    println "m[${e.key}] == ${e.value}"
}

10.downto(7) {println it}

nums4 = nums3.collect { it * 2 }
    .findAll { it % 3 == 0}
    .sum()
println nums4

r2 = strings.collect {it.size()}
strings*.size()

println m.collect { k, v -> "$k=$v"}.join('&')