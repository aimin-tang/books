var str = "aaabbbccc";

function removeLast(str, n) {
    last = str.length - n;
    // if (last < 0) { raise exception; }
    return str.substr(0, last);
}

console.log(removeLast(str, 3));