function insertAfter(node, newPara, p1) {
    p2 = p1.nextSibling;
    if (p2 == null) {
        // need to handle: last already
        node.appendChild(newPara);
    } else {
        node.insertBefore(newPara, p2);
    }
}