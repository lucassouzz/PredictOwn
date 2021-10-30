PREDICT.typeMachine = new Object();

	$(document).ready(function(){
		
		PREDICT.typeMachine.register = function(){
		
			var typeMachine = new Object();
				typeMachine.name = document.formAddTypeMachine.inputType.value;
				typeMachine.descriptionType = document.formAddTypeMachine.inputDesc.value;
				
			console.log(typeMachine);
				$.ajax({
					type : "POST",
					url : PREDICT.PATH + "type/register",
					data : JSON.stringify(typeMachine),
					success : function (msg){
						alert(msg)
						document.formAddTypeMachine.inputType.value = "";
						document.formAddTypeMachine.inputDesc.value = "";
					},
					error : function (msg){
						alert(msg)
					}
					});
			
		}
	});//fim document e function