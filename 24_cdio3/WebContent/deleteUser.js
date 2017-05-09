$(document).ready(function() {
	
	$("#DUButton").click(function() {
		alert("Trying to post...");
		
		$.ajax({
			url: "something",
			method: "POST",
			data: data,
			contentType: "application/json",
			succes: function(data) {
				alert(data);
			},
			error: function(error) {
				alert("Error: " + error);
			}
		});
		
	});
	
	
	//Invalid input - mark with red border around ID input field...
	 $('input[type="number"]').keyup(function(){
		  var value = $(this).val();
		  if(value < 11 || value > 89) {
		    $(this).attr('class', 'w3-border w3-border-red w3-input');
		  }
		  else {
		   $(this).attr('class', 'w3-input');
		  }
	});
	
});