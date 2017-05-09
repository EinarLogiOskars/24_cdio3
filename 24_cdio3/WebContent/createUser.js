$(document).ready(function() {
	$("#CUForm").submit(function(){

		var data = $('#CUForm').serializeObject();
		
		console.log(data);
		
		$.ajax({
			url: "http://localhost:8080/24_cdio3/rest2/cdio3/createuser",
			data: JSON.stringify(data),
			contentType: "application/json",
			method: 'POST',
			success: function(resp){
				console.log('This is the Success method')
				console.log(resp)
			},
			error: function(resp){
				console.log('This is the ERROR method')
				console.log(resp)
			}
		});
		
		// Don't submit the form again
		return false;
	});

	$("#chooseId").click(function() {
		
		$.ajax({
			
			url: "",
			method: "GET",
			success: function(id){
				
			},
			error: function(error){
				alert("Error message: " + error);
			}
		});
		
	});
	
	 $('input[type="text"]').keyup(function(){
		  var value = $(this).val();
		  if(value.length >= 20) {
		    $(this).attr('class', 'w3-border w3-border-red w3-input');
		  }
		  else {
		   $(this).attr('class', 'w3-input');
		  }
		 });

	
});

