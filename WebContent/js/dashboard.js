PREDICT.dashboard = new Object();

$(document).ready(function(){
	
	PREDICT.dashboard.getLastValues = function(){
		
		$.ajax({
			type : "GET",
			url : PREDICT.PATH + "dashboard/getLastValues",
			success : function (return_){
				lastValues = JSON.parse(return_)
				console.log(lastValues)
				var current =  (lastValues.c1 + lastValues.c2 + lastValues.c3) / 3
				var voltage =  (lastValues.t1 + lastValues.t2 + lastValues.t3) / 3
				var spanCurrent = document.getElementById("spanCorrente")
				var spanVoltage = document.getElementById("spanTensao")
				var spanMachineTemp = document.getElementById("spanTempM")
				var spanLocalTemp = document.getElementById("spanTempL")
				spanCurrent.textContent = current
				spanVoltage.textContent = voltage
				spanMachineTemp.textContent = lastValues.machineTemp
				spanLocalTemp.textContent = lastValues.localTemp
				
			},
			error : function (return_){
				alert(return_)
			}
			});
		
	}
	
	PREDICT.dashboard.getLastValues()
	
})//End function and document