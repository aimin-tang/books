var lines = 8;

// construct odd_line and even_line
var odd_line = "";
var even_line = "";

for (var i=1; i<=lines; i++) {
    if (i % 2 == 1) {
        odd_line += "#";
        even_line += " ";
    } else {
        odd_line += " ";
        even_line += "#";
    }
}

for (var i=1; i<=lines; i++) {
    if (i % 2 == 1) {
        console.log(odd_line);
    } else {
        console.log(even_line);
    }
}