str = "the brown fox jumped over the orange cat";

console.log(
    str.split().map(function (t) {
        t.toUpperCase();
    }).reduce(function (s1, s2) {
        s1 + " " + s2;
    })
)