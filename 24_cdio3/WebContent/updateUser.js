$(document).ready(function() {
	
	var user;
	
	$("#UUButton").click(function() {		
		$.ajax({
			url: "something",
			method: "POST",
			data: data,
			contentType: "application/json",
			success: function(data) {
				user = data;
				$("#UUForm").load("updateUserForm");
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