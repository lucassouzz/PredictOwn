PREDICT.graphic = new Object();

$(document).ready(function(){
	
	$(document).ready(function () {
		PREDICT.graphic.updateValues();
    });
	
	const ctx = document.getElementById('temperatureChart').getContext('2d');
	const temperatureChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: [],
	        datasets: [{
	            label: ['Temperatura Motor'],
	            data: [],
	            backgroundColor: [
	            	'rgba(135,206,250)'		          
	            ],
	            borderColor: [
	                'rgba(135,206,250)'	                             
	            ],
	            borderWidth: 1	          
	        },
	        {
	        	label : ["Temperatura Ambiente"],
	        	data: [],
	            backgroundColor: [
	            	'rgba(32,178,170)'		                
	            ],
	            borderColor: [
	            	'rgba(32,178,170)'	                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Predição"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	            	'rgba(255,69,0)'
	            ],
	            borderColor: [	                   
	                'rgba(255,69,0)'
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Temperatura Limite"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	            	'rgba(255,0,0)'
	            ],
	            borderColor: [	                   
	                'rgba(255,0,0)'
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
	        labels: [],
	        datasets: [{
	            label: ["Corrente 1"],
	            data: [],
	            backgroundColor: [
	            	'rgba(135,206,250)'		          
	            ],
	            borderColor: [
	            	'rgba(135,206,250)'	             
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Corrente 2"],
	        	data: [],
	            backgroundColor: [
	            	'rgba(65,105,225)'			                
	            ],
	            borderColor: [
	            	'rgba(65,105,225)'		              
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Corrente 3"],
	        	data: [],
	            backgroundColor: [
	            	'rgba(70,130,180)'			                
	            ],
	            borderColor: [
	            	'rgba(70,130,180)'		                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Predição 1"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,69,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,69,0)'                
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Predição 2"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,140,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,140,0)'                
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Predição 3"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,165,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,165,0)'	                     
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Corrente Limite"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	            	'rgba(255,0,0)'
	            ],
	            borderColor: [	                   
	                'rgba(255,0,0)'
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
	        labels: [],
	        datasets: [{
	            label: ["Tensão 1"],
	            data: [],
	            backgroundColor: [
	            	'rgba(135,206,250)'		          
	            ],
	            borderColor: [
	            	'rgba(135,206,250)'	             
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Tensão 2"],
	        	data: [],
	            backgroundColor: [
	            	'rgba(65,105,225)'		                
	            ],
	            borderColor: [
	            	'rgba(65,105,225)'		                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Tensão 3"],
	        	data: [],
	            backgroundColor: [
	            	'rgba(70,130,180)'	                
	            ],
	            borderColor: [
	            	'rgba(70,130,180)'		                
	            ],
	            borderWidth: 1
	        },
	        {
	        	label : ["Predição 1"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,69,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,69,0)'                
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Predição 2"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,140,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,140,0)'                
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Predição 3"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	                'rgba(255,165,0)'	                
	            ],
	            borderColor: [
	            	'rgba(255,165,0)'	                     
	            ],
	            borderWidth: 2,
	            borderDash: [5,5]
	        },
	        {
	        	label : ["Tensão Limite"],
	        	data: [],
	        	pointRadius: 0,
	            backgroundColor: [
	            	'rgba(255,0,0)'
	            ],
	            borderColor: [	                   
	                'rgba(255,0,0)'
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
				temperatureChart.data.datasets[0].data = [];
				temperatureChart.data.datasets[1].data = [];
				temperatureChart.data.datasets[2].data = [];
				temperatureChart.data.datasets[3].data = [];
				currentChart.data.datasets[0].data = [];
				currentChart.data.datasets[1].data = [];
				currentChart.data.datasets[2].data = [];
				currentChart.data.datasets[6].data = [];
				voltageChart.data.datasets[0].data = [];
				voltageChart.data.datasets[1].data = [];
				voltageChart.data.datasets[2].data = [];
				currentChart.data.datasets[6].data = [];
	
				temperatureChart.data.labels = [];
				currentChart.data.labels = [];
				voltageChart.data.labels = [];
				
				for (i = 0; i < dataObj.length; i++){
					temperatureChart.data.datasets[0].data.push(dataObj[i].machineTemp);
					temperatureChart.data.datasets[1].data.push(dataObj[i].localTemp);
					temperatureChart.data.datasets[3].data.push('90');
					temperatureChart.data.labels.push(hours);
					
					currentChart.data.datasets[0].data.push(dataObj[i].c1);
					currentChart.data.datasets[1].data.push(dataObj[i].c2);
					currentChart.data.datasets[2].data.push(dataObj[i].c3)
					currentChart.data.datasets[6].data.push('1.2')
					currentChart.data.labels.push(hours);
					
					voltageChart.data.datasets[0].data.push(dataObj[i].t1);
					voltageChart.data.datasets[1].data.push(dataObj[i].t2);
					voltageChart.data.datasets[2].data.push(dataObj[i].t3)
					voltageChart.data.datasets[6].data.push('254')
					voltageChart.data.labels.push(hours);
					
				}
				
				temperatureChart.data.datasets[0].data.reverse();
				temperatureChart.data.datasets[1].data.reverse();
				temperatureChart.data.datasets[2].data.reverse();
				currentChart.data.datasets[0].data.reverse();
				currentChart.data.datasets[1].data.reverse();
				currentChart.data.datasets[2].data.reverse();
				voltageChart.data.datasets[0].data.reverse();
				voltageChart.data.datasets[1].data.reverse();
				voltageChart.data.datasets[2].data.reverse();
				
				
				temperatureChart.update();
				currentChart.update();				
				voltageChart.update();
				
				PREDICT.graphic.updateFutureValues();
				
			},
			error : function (msg){
				alert("Quebrandoooo");
			}
		});
	}
	setInterval(PREDICT.graphic.updateValues, 60000*5);
	
	PREDICT.graphic.updateFutureValues = function () {
		var data = new Date()
		var hours = data.getHours() + ":" + data.getMinutes();
		$.ajax({
			type : "GET", 
			url : PREDICT.PATH + "graphic/updateFutureValues",
			success : function (data){

				var dataObj = JSON.parse(data);	
				for(x = 0; x < temperatureChart.data.datasets[0].data.length; x++){
					if (x == 99){
						temperatureChart.data.datasets[2].data.push(temperatureChart.data.datasets[0].data[x]);						
					}else{
						temperatureChart.data.datasets[2].data.push(null);						
					}	
					temperatureChart.data.datasets[3].data.push('90');
				}
				
				for (i = 0; i < dataObj.length; i++){
					temperatureChart.data.datasets[2].data.push(dataObj[i].machineTemp);
					temperatureChart.data.labels.push(hours);	
				}
				
				for (y = 0; y < currentChart.data.datasets[0].data.length; y++) {
					if (y == 99){
						currentChart.data.datasets[3].data.push(currentChart.data.datasets[0].data[y]);
						currentChart.data.datasets[4].data.push(currentChart.data.datasets[1].data[y]);
						currentChart.data.datasets[5].data.push(currentChart.data.datasets[2].data[y]);
					}else{
						currentChart.data.datasets[3].data.push(null);
						currentChart.data.datasets[4].data.push(null);
						currentChart.data.datasets[5].data.push(null);
					}	
					currentChart.data.datasets[6].data.push('1.2')
				} 
				
				for (i = 0; i < dataObj.length; i++){
					currentChart.data.datasets[3].data.push(dataObj[i].c1);
					currentChart.data.datasets[4].data.push(dataObj[i].c2);
					currentChart.data.datasets[5].data.push(dataObj[i].c3);
					currentChart.data.labels.push(hours);	
				}
				
				for (i = 0; i < voltageChart.data.datasets[0].data.length; i++) {
					if (i == 99){
						voltageChart.data.datasets[3].data.push(voltageChart.data.datasets[0].data[i]);
						voltageChart.data.datasets[4].data.push(voltageChart.data.datasets[1].data[i]);
						voltageChart.data.datasets[5].data.push(voltageChart.data.datasets[2].data[i]);
					}else{
						voltageChart.data.datasets[3].data.push(null);
						voltageChart.data.datasets[4].data.push(null);
						voltageChart.data.datasets[5].data.push(null);
					}		
					voltageChart.data.datasets[6].data.push('254')
				} 
				
				for (i = 0; i < dataObj.length; i++){
					voltageChart.data.datasets[3].data.push(dataObj[i].t1);
					voltageChart.data.datasets[4].data.push(dataObj[i].t2);
					voltageChart.data.datasets[5].data.push(dataObj[i].t3);
					voltageChart.data.labels.push(hours);	
				}
				
				temperatureChart.update();
				currentChart.update();
				voltageChart.update();
				
			},
			error : function (msg){
				alert("Quebrandooo")
			}
		})
	}
	
});
