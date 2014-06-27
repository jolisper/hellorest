

var buffer = {};

function randomInt (low, high) {
    return Math.floor(Math.random() * (high - low) + low);
}

exports.getAll = function() {
	var arr = [];
	
	for (var k in buffer) {
		if(k) {
			arr.push({ id:k, texto:buffer[k] });
		}
	};
	
	return arr; 
}

exports.set = function(id, text){
	buffer[id] = text;
	
	return { id:id, texto:text };
}

exports.add = function(text){
	var id = randomInt(0, 10000);
	buffer[id] = text;
	
	return { id:id, texto:text };
};

exports.get = function(id){
	return { id:id, texto:buffer[id] };
};
