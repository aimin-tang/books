var str = "the brown fox jumped over the orange cat";
console.log(str);

console.log(str.split(" "));

console.log(
    str.split(" ").map(function (t) {
        return t[0].toUpperCase() + t.substr(1);
    }).reduce(function (s1, s2) {
        return s1 + " " + s2;
    })
);
