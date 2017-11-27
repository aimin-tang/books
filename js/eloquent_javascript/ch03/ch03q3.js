function countChar(str, char) {

    count = 0;

    for (var i=0; i<str.length; i++) {
        if (str.charAt(i) == char) count += 1;
    }

    return count;
}

console.log(countChar("abhacadabra", "a"));