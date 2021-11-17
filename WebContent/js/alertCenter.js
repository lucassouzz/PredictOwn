PREDICT.alert = new Object();

$(document).ready(function(){
	
	PREDICT.alert.addAlert = function () {	
		
		var teste = "Motor de Indução Trifásico";	
		$.ajax({
			type : "GET",
			url : PREDICT.PATH + "alertCenter/triggerAlert",
			success : function (data) {
				var dataObj = JSON.parse(data);
				for (i = 0; i < dataObj.length; i++){
					$("#divAlert").append("</a> <a class='dropdown-item d-flex align-items-center' href='#'> " +
							" <div class='mr-3'>" +
							"	<div class='icon-circle bg-warning'> " +								
							"		<i class='fas fa-exclamation-triangle text-white'></i> " +
							"	</div> " +
							"</div> " +
							"<div> "+
							"	<div class='small text-gray-500'>"+dataObj[i].dateHour+"</div> " +
							"	Alerta: " + teste + 
							" Atingiu " +dataObj[i].machineTemp+ "°" +								
							"</div> "+
						"</a>");
				}

				PREDICT.alert.addCounter();
				
			}
		})
	}
	
	PREDICT.alert.addCounter = function () {
		let counter = document.querySelector("#divAlert").childElementCount;
		if (counter > 2){
			counter = counter - 2;
			document.querySelector("#divShowCounter").innerHTML = "<span class='badge badge-danger badge-counter'>"+counter+"</span>";	
		}else{
			document.querySelector("#divShowCounter").innerHTML = "<span class='badge badge-danger badge-counter'></span>";
		}
	}
	
});