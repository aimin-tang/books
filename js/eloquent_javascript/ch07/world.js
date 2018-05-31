var plan =
    ["############################",
        "#      #    #      o      ##",
        "#                          #",
        "#          #####           #",
        "##         #   #    ##     #",
        "###           ##     #     #",
        "#           ###      #     #",
        "#  ####                    #",
        "#  ##        o             #",
        "# o #          o       ### #",
        "#   #                      #",
        "############################"];

function Vector(x, y) {
    this.x = x;
    this.y = y;
}

Vector.prototype.plus = function (other) {
    return new Vector(this.x + other.x, this.y + other.y);
}

let val;
val = String([1, 2, 3, 4]);
console.log(val.length);