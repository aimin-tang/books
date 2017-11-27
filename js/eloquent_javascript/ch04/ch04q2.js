function reverseArray(array) {
    newArray = [];

    for (var i=array.length-1; i>=0; i--) {
        newArray.push(array[i]);
    }

    return newArray;
}

function reverseArrayInPlace(array) {
    changeTimes = Math.floor(array.length / 2);

    for (var i=0; i<changeTimes; i++) {
        var tmp = array[i];
        array[i] = array[array.length - i - 1];
        array[array.length - i - 1] = tmp;
    }
}

array = [1, 2, 3, 4, 5]
// console.log(reverseArray(array), reverseArrayInPlace(array));
console.log(array);
console.log(reverseArray(array));
reverseArrayInPlace(array);
console.log(array);
