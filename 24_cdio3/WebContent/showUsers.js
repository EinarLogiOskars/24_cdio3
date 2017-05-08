$(document).ready(function() {
	$("#SUButton").click(function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/24_cdio3/rest2/cdio3/showuser",
			succes: function(data) {
				alert("Got data:" + data)
			}
		});
	});
});
