$(document).ready(function() {
	var response;
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/24_cdio3/rest2/cdio3/showusers",
		succes: function(data) {
			response = data;
		},
		complete: loadtable()
	});

	function loadtable(){
		response = $.parseJSON(response);

		$.each(response, function(i, item) {
			var $tr = $('<tr>').append(
					$('<td>').text(item.userId),
					$('<td>').text(item.userName),
					$('<td>').text(item.ini),
					$('<td>').text(item.roles)
			); //.appendTo('#records_table');
			console.log($tr.wrap('<p>').html());
		});
	}
});