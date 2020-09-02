
$(setup)
function setup() {
	$('.intro select').zelect({})
}

function singlePopertyimgErr(image){
	
image.onerror ="";
image.src="/images/no-image-icon-23485.png";
return true;
}

// change style for select box
$(".selectbox").selectbox();


$(document).ready(function() {
	$("#owner").hide();
	$("#ownerContact").prop('disabled',false);
	var count = 1;
	$("#ownerContact").click(function() {
	
		var clickcount = {
				"clickcount" : count
			};
		
		$.ajax({
			type: "POST",	
			url: "/property/getOwnerInformation",
			data: clickcount,			
			success: function (data) {
					//$(".submit").prop('disabled', false);
				
					if(data === true)
					{
						
						$("#owner").show();
						$("#ownerContact").prop('disabled',true);
					}
					else
						{
						$("#ownerContact").prop('disabled',true);
						window.location.href="/Buy-Package";
						}
				},
				error: function () {
						alert("could not insert");
				}
		});

	});
});





/*
//Add new Image after click on Button
$(document).ready(function() {
					var count = 2;
					$("#addImage").click(function() {
					//Add new Image Button
					count++;
					alert(count);
					if (count <= 10) {
						var newRow = $('<div id="upload-widget" class="dropzone margin20 bottom20" ><label style="color: red">Propertise Images (Size 218 * 171)</label><div class="dz-default ">'
							+ '<input type="file"   id="propertyImage'+ count+ '" name="propertyImage'+ count + '"></div></div>');
									$('#newRow').append(newRow);
					} else {
					alert("Only 10 Images are allowed");
					$("#addImage").prop('disabled',true);
					  }
					});
				});

//New Property Form

$(".addProperty").submit(function (event) {
	event.preventDefault();
	var form = {}
	form["propertyName"] = $(".propertyName").val();
	form["propertyAddress"] = $(".propertyAddress").val();
	form["propertyImage1"] = $(".propertyImage1").val();
	
	$.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/property/saveNewProperty",
	data: JSON.stringify(form),
	dataType: 'json',
	cache: false,
	timeout: 600000,
	
	success: function (data) {
	//$(".submit").prop('disabled', false);
	$('#productDetailForm')[0].reset();
	alert("done");
	console.log("SUCCESS : ", data);
	},
	error: function () {
	alert('could not insert');
	}
	});
	});


			*/						