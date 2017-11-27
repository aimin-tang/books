var range = function(start, end, step) {

    var array = [];

    if (step == undefined) step = 1;

    if (step > 0) {
        for(var i=start; i<=end; i+=step) {
            array.push(i);
        }
    } else if (step < 0) {
        for(var i=start; i>=end; i+=step) {
            array.push(i);
        }
    }

    return array;
}

var sum = function (array) {
    var sum = 0;

    for (var i=0; i<array.length; i++) {
        sum += array[i];
    }

    return sum;

}


console.log(sum(range(1, 10)));
