function arrayToList(array) {
    lastObj = {
        value: array[array.length -1],
        rest: null
    }

    for (var i=array.length-2; i>=0; i--) {
        lastObj = {
            value: array[i],
            rest: lastObj
        }
        console.log(lastObj);
    }

    return lastObj;
}

function listToArray(list) {
    array = [];

    array.push(list.value);
    newList = list.rest;
    if (newList != null) {
        array = array + listToArray(newList);
    }

    return array;
}

function prepend(element, list) {
    var newList = {
        value: element,
        rest: list
    }

    return newList;
}

array = [1, 2, 3, 4, 5]
list = arrayToList(array);
console.log("list: ", list);
array2 = listToArray(list);
console.log("array2: ", array2);
