Date.prototype.getYesterday = function () {
    var yDay = new Date(this.valueOf());
    yDay.setDate(yDay.getDate() - 1);
    return yDay;
}

tDay = new Date();
console.log(tDay.getDay())
console.log(tDay.getYesterday().getDay())
