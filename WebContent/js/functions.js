/**
 * 
 */
$(function() {
	var $obj = $('tr:eq(0)').children('td');
	var len = $obj.length;
	var lastTd = $obj.get(len - 1);
	$(lastTd).css('width', '80px');
});

$.fn.back_blue = function() {
	this.css("background-color", "blue");
}

$.fn.text_red = function() {
	this.css('color', 'red');
}

$.fn.require = function(errMsg, errCtn) {
	var value = this.val();
	if (value != null && value.length > 0) {
		$(errCtn).text('');
		return true;
	} else {
		$(errCtn).text(errMsg);
		return false;
	}
}

$.fn.remote = function(url, errMsg, errCtn) {
	var b = false;
	var value = this.val();
	var name = this.attr("name");
	// alert(value + "," + name);
	$.ajax({
		url : url,
		type : "post",
		data : name + "=" + value,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data) {
				$(errCtn).text('');
				b = true;
			} else {
				$(errCtn).text_red();
				$(errCtn).back_blue();
				$(errCtn).text(errMsg);
			}
		}
	});
	return b;
}

$.fn.range = function(min, max, errMsg, errCtn) {
	var value = this.val();
	if (value != null && value.length >= min && value.length <= max) {
		$(errCtn).text('');
		return true;
	} else {
		$(errCtn).text(errMsg);
		return false;
	}
}

$.fn.intRange = function(min, max, errMsg, errCtn){
	var value = this.val();
	var re = /^[1-9]\d*$/;
	var b = false;
	if(re.test(value)){
		var n = parseInt(value);
		if(n >= min && n <= max)
			b = true;
	}
	if(b){
		$(errCtn).text('');
		return true;
	}else{
		$(errCtn).text_red();
		$(errCtn).text(errMsg);
		return false;
	}
};

