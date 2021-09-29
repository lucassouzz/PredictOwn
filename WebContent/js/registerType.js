alert("chegou!");
PREDICT.registerType = new Object();

	$(document).ready(function(){
		
		PREDICT.registerType.register = function(){
		
			var typeMachine = new Object();
				typeMachine.name = document.formAddTypeMachine.inputType.value;
				typeMachine.desc = document.formAddTypeMachine.inputDesc.value;
				
			console.log(typeMachine);
				$.ajax({
					type : "POST",
					url : PREDICT.PATH + "type/register",
					data : JSON.stringify(typeMachine),
					success : function (msg){
						
					},
					error : function (msg){
						alert(msg)
					}
					});
			
		}
	});//fim document e function