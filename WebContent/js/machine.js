PREDICT.machine = new Object();

$(document).ready(function(){
	
	PREDICT.machine.register = function(){
		
		var machine = new Object()
			machine.typeMachine_idType = parseInt(document.formRegisterMachine.idType.value);
		
		if (machine.typemachine_idType == "") {
			return alert("Selecione um tipo de equipamento!")
		}
			machine.name = document.formRegisterMachine.name.value;
			machine.descriptionMachine = document.formRegisterMachine.description.value;
			machine.tMin = document.formRegisterMachine.tMin.value;
			machine.tMax = document.formRegisterMachine.tMax.value;
			machine.cMin = document.formRegisterMachine.cMin.value;
			machine.cMax = document.formRegisterMachine.cMax.value;
			machine.tempMin = document.formRegisterMachine.tempMin.value;
			machine.tempMax = document.formRegisterMachine.tempMax.value;
			console.log(machine);
			$.ajax({
				type : "POST",
				url : PREDICT.PATH + "machine/register",
				data : JSON.stringify(machine),
				success : function (msg){
					alert(msg)
					
				},
				error : function (msg){
					alert(msg)
				}
				});
		
	}
	
	PREDICT.machine.supplySelect = function(idSelect) {

		$
					.ajax({
						type : "GET",
						url : PREDICT.PATH + "machine/searchTypeMachine",
						success : function(listTypeMachine) {

							if (listTypeMachine != "") {

								$(idSelect).html("");

								var option = document.createElement("option");
								option.setAttribute("value", "");
								option.innerHTML = ("Selecione a opção desejada");
								$(idSelect).append(option);

								for (var i = 0; i < listTypeMachine.length; i++) {

									var option = document.createElement("option");
									option.setAttribute("value", listTypeMachine[i].idType);
									
									option.innerHTML = (listTypeMachine[i].name);
									$(idSelect).append(option);

								}

							} else {

								$(idSelect).html("");

								var option = document.createElement("option");
								option.setAttribute("value", "");
								option.innerHTML = ("Cadastre um tipo de equipamento primeiro!");
								$(idSelect).append(option);
								$(idSelect).addClass("aviso");
							}
						},
						error : function(info) {
							LAPADOCCA
									.exibirAviso("Erro ao buscar os tipos de maquinas cadastrados: "
											+ info.status
											+ " - "
											+ info.statusText);

							$(idSelect).html("");
							var option = document
									.createElement("option");
							option.setAttribute("value", "");
							option.innerHTML = ("Erro ao carregar tipos de maquinas!");
							$(idSelect).append(option);
							$(idSelect).addClass("aviso");
						}
					});

		}
	
	PREDICT.machine.supplySelect("#selTypeMachine");
	
});// fim document
