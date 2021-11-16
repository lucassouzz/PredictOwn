PREDICT.graphic = new Object();

$(document).ready(function(){
	
	const labelData1 = ['12:25', '12:30', '12:35', '12:05', '12:10', '12:15', '12:20', '12:25', '12:30', '12:35'];
	const labelData2 = null;
	const values = null;
	
	const ctx = document.getElementById('temperatureChart').getContext('2d');
	const temperatureChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: [],
	        datasets: [{
	            label: ['Temperatura Motor'],
	            data: [],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)'	          
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	             
	            ],
	            borderWidth: 1	          
	        },
	        {
	        	label : ["Temperatura Ambiente"],
	        	data: [],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)'	                
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Predição"],
	        	data: [],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgb(0,0,0,0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',	   
	                'rgbargb(0,0,0,0.2)'
	            ],
	            borderWidth: 1
	        }
	        ]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	
	const ctx2 = document.getElementById('currentChart').getContext('2d');
	const currentChart = new Chart(ctx2, {
	    type: 'line',
	    data: {
	        labels: ['11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50'],
	        datasets: [{
	            label: ["Corrente 1"],
	            data: [12, 19, 3, 5, 2, 3, 15, 19, 13, 5, 22, 13],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	          
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	             
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Corrente 2"],
	        	data: [9, 9, 13, 15, 12, 13, 5, 9, 3, 15, 2, 7],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	                
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Corrente 3"],
	        	data: [4, 19, 16, 9, 16, 8, 7, 10, 13, 20, 22, 18],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	                
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	                
	            ],
	            borderWidth: 1
	        }
	        ]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	
	const ctx3 = document.getElementById('voltageChart').getContext('2d');
	const voltageChart = new Chart(ctx3, {
	    type: 'line',
	    data: {
	        labels: ['11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50', '11:50'],
	        datasets: [{
	            label: ["Tensão 1"],
	            data: [12, 19, 3, 5, 2, 3, 15, 19, 13, 5, 22, 13],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	          
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	             
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Tensão 2"],
	        	data: [9, 9, 13, 15, 12, 13, 5, 9, 3, 15, 2, 7],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	                
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Tensão 3"],
	        	data: [4, 19, 16, 9, 16, 8, 7, 10, 13, 20, 22, 18],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(54, 162, 235, 0.2)'	                
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'	                
	            ],
	            borderWidth: 1
	        }
	        ]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	
	PREDICT.graphic.updateValues = function(){
		var data = new Date()
		var hours = data.getHours() + ":" + data.getMinutes();
		$.ajax({
			type : "GET",
			url : PREDICT.PATH + "graphic/updateValues",
			success : function (data){
				var dataObj = JSON.parse(data);
				for (i = 0; i < dataObj.length; i++){
					temperatureChart.data.datasets[0].data.push(dataObj[i].machineTemp);
					temperatureChart.data.datasets[1].data.push(dataObj[i].localTemp);
					temperatureChart.data.labels.push(hours);
					
					currentChart.data.datasets[0].data.push(dataObj[i].c1);
					currentChart.data.datasets[1].data.push(dataObj[i].c2);
					currentChart.data.datasets[2].data.push(dataObj[i].c3)
					currentChart.data.labels.push(hours);
					
					voltageChart.data.datasets[0].data.push(dataObj[i].t1);
					voltageChart.data.datasets[1].data.push(dataObj[i].t2);
					voltageChart.data.datasets[2].data.push(dataObj[i].t3)
					voltageChart.data.labels.push(hours);
					
				}
				temperatureChart.update();
				currentChart.update();				
				voltageChart.update();
				
			
			},
			error : function (msg){
				alert("Quebrandoooo");
			}
		});
	}
	setInterval(PREDICT.graphic.updateValues, 60000*5);
	
	
	PREDICT.graphic.updateFutureValues = function () {
		$.ajax({
			type : "POST", 
			url : PREDICT.PATH + "graphic/updateFutureValues",
			success : function (data){
				var dataObj = JSON.parse(data);
				console.log(dataObj);
				
				temperatureChart.data.datasets[2].data.push(dataObj.machineTemp);
				temperatureChart.data.labels.push(hours);
				temperatureChart.update();
				
			},
			error : function (msg){
				alert("Quebrandooo")
			}
		})
	}
	//setInterval(PREDICT.graphic.updateFutureValues, 3000);
	
});