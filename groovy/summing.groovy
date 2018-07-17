List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]
println nums

// Java approach
int total = 0
for (int n: nums) {
    total += 2 * n
}
assert total == 72

// Groovy collect
assert 72 == nums.collect {it * 2}.sum()

// Groovy with closure
assert 72 == nums.sum{it * 2}

// spread dot
assert 72 == nums*.multiply(2).sum()

// double collection
assert 72 == (nums * 2).sum()

// use inject
assert 72 == nums.inject(0) { acc, val ->
    acc + val * 2
}