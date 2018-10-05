String base = 'https://maps.googleapis.com/maps/api/geocode/xml?'
def encoded = ['10 Fawcett Street', 'Cambridge', 'MA'].collect {
    URLEncoder.encode(it, 'UTF-8')
}.join(',')
def url = "${base}address=${encoded}"
def root = new XmlSlurper().parse(url)
def loc = root.result[0].geometry.location
println "(${loc.lat},${loc.lng})"