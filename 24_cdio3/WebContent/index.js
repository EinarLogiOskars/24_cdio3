$(document).ready(function() {
	
	$("#createuser").on("click", function() {
		$("#div2").load("createUser.html");
	});

//	$("#showusers").click(function() {
//		$("#div2").load("showUsers.html");
//	});

	$("#updateuser").click(function() {
		$("#div2").load("updateUser.html");
	});	

	$("#deleteuser").click(function() {
		$("#div2").load("deleteUser.html");
	});

	$("#showusers").on("click", function(){
		alert("hello");
		$.ajax({
			type: 'GET',
			url: "http://localhost:8080/24_cdio3/rest2/cdio3/showusers",
			success: function(data) {
				$("#div2").load("http://localhost:8080/24_cdio3/rest2/cdio3/showusers");
			}, 
			error: function(){
				alert("error");
			}
		});
	});
});
