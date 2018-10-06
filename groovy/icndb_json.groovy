import groovy.json.*

String base = 'http://api.icndb.com/jokes/random?'
def qs = [limitTo: '[nerdy]'].collect { k, v -> "$k=$v" }.join('&')
String jsonTxt = "$base$qs".toURL().text
def json = new JsonSlurper().parseText(jsonTxt)
println json.value.joke