function makeMenu() {
    // get all the H2 heading elements
    var h2s = document.getElementsByTagName("h2");
    // create a new page element for the menu
    var menu = document.createElement("div");
    // create a UL element and append to the menu div
    var menuUl = document.createElement("ul");
    menu.appendChild(menuUl);
    // cycle through h2 headings
    for(var i = 0; i < h2s.length; i++) {
        // get text node of h2 element
        var itemText = h2s[i].childNodes[0].nodeValue;
        // add a list item
        var menuLi = document.createElement("li");
        // add it to the menu list
        menuUl.appendChild(menuLi);
        // the list item contains a link
        var menuLiA = document.createElement("a");
        menuLiA = menuLi.appendChild(menuLiA);
        // set the href of the link
        menuLiA.setAttribute("href", "#item" + i);
        // set the text of the link
        var menuText = document.createTextNode(itemText);
        menuLiA.appendChild(menuText);
        // create matching anchor element
        var anc = document.createElement("a");
        anc.setAttribute("name", "item" + i);
        // add anchor before the heading
        document.body.insertBefore(anc, h2s[i]);

        // add "Back to top" for each h2
        var backToTop = document.createElement("a");
        backToTop.setAttribute("href", "#top");
        var textNode = document.createTextNode("Back to top");
        backToTop.append(textNode);
        var p = h2s[i].nextSibling;
        document.body.insertBefore(backToTop, p);
    }
    // add menu to the top of the page
    document.body.insertBefore(menu, document.body.firstChild);
    document.body.insertBefore(menu, document.body.firstChild);

    // add top before menu
    var top = document.createElement("a");
    top.setAttribute("name", "top");
    document.body.insertBefore(top, menu);
}