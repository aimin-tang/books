console.log([[1, 2], [3, 4], [5, 6, 7]].reduce(function(array1, array2) {
    return array1.concat(array2);
}, []))