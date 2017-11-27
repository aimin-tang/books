function every(array, f) {
    for (var i=0; i<array.length; i++) {
        if (f(array[i]) == false) return false;
    }
    return true;
}

function some(array, f) {
    for (var i=0; i<array.length; i++) {
        if (f(array[i])) return true;
    }
    return false
}
var array = [2, 4, 6, 8, 9, 10];
r = every(array, function(e) {
    return e % 2 == 0;
})

console.log(r);

var array = [2, 4, 6, 8, 10];
r = some(array, function(e) {
    return e % 2 == 1;
})

console.log(r);
