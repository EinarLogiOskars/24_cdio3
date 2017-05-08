$(document).ready(function() {
	$("#CUButton").on("click", function(){
		
		var data = $('form#CUForm').serializeObject();
		
		$.ajax({
			url: "http://localhost:8080/24_cdio3/rest2/cdio3/createuser",
			data: data,
			contentType: "application/json",
			method: 'POST',
				
		});

	});
	
	});

