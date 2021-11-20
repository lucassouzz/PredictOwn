PREDICT.machine = new Object();

$(document)
		.ready(
				function() {

					PREDICT.machine.searchRegistryMachine = function() {

						$
								.ajax({
									type : "GET",
									url : PREDICT.PATH
											+ "machine/searchRegistryMachine",
									success : function(listMachine) {
										$('#listMachine')
												.html(
														PREDICT.machine
																.buildTable(listMachine))
									},
									error : function(listMachine) {
										alert("Erro ao buscar tipos de equipamentos cadastrados.")
									}

								})
					}

					PREDICT.machine.buildTable = function(listMachine) {

						var table = "<table class='table align-items-center table-flush'>"
								+ "<thead class='thead-light'>"
								+ "<tr>"
								+ "<th>Nome</th>"
								+ "<th>Descrição</th>"
								+ "<th>Opções</th>"
								+ "</tr>"
								+ "</thead>"
								+ "<tbody>"

						if (listMachine.length > 0) {
							for (var i = 0; i < listMachine.length; i++) {
								table += "<tr><td>"
										+ listMachine[i].name
										+ "</td>"
										+ "<td>"
										+ listMachine[i].descriptionMachine
										+ "</td>"
										+ "<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModal' id='#myBtn' onclick=PREDICT.machine.deleteMachine("
										+ listMachine[i].idMachine
										+ ")>Excluir</button>"
										+ "<button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModalScrollable' id=#modalScroll' onclick=PREDICT.machine.machineModalEdit("
										+ listMachine[i].idMachine
										+ ")>Editar</button></td></tr>"
							}

						} else if (listMachine == "") {
							table += "<tr><td>Nenhum registro encontrado</td></tr>";
						}
						table += "</tbody></table>"

						return table;
					}

					PREDICT.machine.searchRegistryMachine();

					PREDICT.machine.deleteMachine = function(idMachine) {

						$.ajax({
							type : "DELETE",
							url : PREDICT.PATH + "machine/machineDelete/"
									+ idMachine,
							success : function(msg) {
								alert(msg)
								PREDICT.machine.searchRegistryMachine();
							},
							error : function(msg) {
								alert("Erro ao excluir tipo de equipamento.")
							}

						})

					}
					
					PREDICT.machine.machineModalEdit = function(idMachine) {

						$.ajax({
							type : "GET",
							url : PREDICT.PATH + "machine/searchRegistryById/"
									+ idMachine,
							success : function(machine) {
								machine = JSON.parse(machine)

								$("#editMachine").html(PREDICT.machine.buildModalEdit(machine));
//								PREDICT.machine.supplySelect(selNewTypeMachine);
//								PREDICT.machine.setValueOfRegistry(machine);
							},
							error : function(msg) {

							}

						})		

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
					
					PREDICT.machine.setValueOfRegistry = function (machine){
						document.formEditMachine.newName.value = machine.name; 
						document.formEditMachine.newDescription.value = machine.descriptionMachine; 
						document.formEditMachine.newTmin.value = machine.tMin;
						document.formEditMachine.newTmax.value = machine.tMax; 
						document.formEditMachine.newCmin.value = machine.cMin; 
						document.formEditMachine.newCmax.value = machine.cMax;
						document.formEditMachine.newTempMin.value = machine.tempMin; 
						document.formEditMachine.newTempMax.value = machine.tempMax; 
//						document.formEditMachine.idType.value = machine.typeMachine_idType; 
					}

					PREDICT.machine.buildModalEdit = function(machine) {
						
						var modal = "<div class='modal fade show' id='exampleModalScrollable' tabindex='-1' role='dialog' aria-labelledby='exampleModalScrollableTitle' aria-modal='true' style='display: block;'>"
								+ "<div class='modal-dialog modal-dialog-scrollable' role='document'>"
								+ "<div class='modal-content'>"
								+ "<div class='modal-header'>"
								+ "<h5 class='modal-title' id='exampleModalScrollableTitle'>Editar</h5>"
								+ "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
								+ "<span aria-hidden='true'>×</span>"
								+ "</button>"
								+ "</div>"
								+ "<div class='modal-body'>"
								+ "<div class='card mb-4'>"
								+ "<div class='card-body'>"
								+ "<form name='formEditMachine'>"
								+ "<div class='card-header py-3 d-flex flex-row align-items-center justify-content-between'>"
								+ "</div>"
								+ "<div class='form-group'>"
								+ "<label for='exampleFormControlSelect1'>Tipo</label>"
								+ "<select class='form-control' name='idType' id='selNewTypeMachine'>"
								+ "<option value='' class='buscando'>Aguarde, buscando tipo de maquina cadastrado...</option>"
								+ "</select>"
								+ "</div>"
								+ "<div class='form-group'>"
								+ "<label for='exampleInputEmail1'>Nome</label>"
								+ "<input type='email' class='form-control' id='newName' aria-describedby='emailHelp'>"
								+ "<small id='emailHelp' class='form-text text-muted'></small>"
								+ "</div>"
								+ "<div class='form-group'>"
								+ "<label for='exampleFormControlTextarea1'>Descrição</label>"
								+ "<textarea class='form-control' id='newDescription' rows='3'></textarea>"
								+ "</div>"
								+ "<div class='card-header py-3 d-flex flex-row align-items-center justify-content-between'>"
								+ "<h6 class='m-0 font-weight-bold text-primary'>Parâmetros</h6>"
								+ "</div>"
								+ "<div class='card-body'>"
								+ "<div class='row'>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-primary text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Tensão Mínima</label>"
//								+ "<label for='exampleInputEmail1' id='tMin'>"+ machine.tMin+" V</label>"
								+ "<input type='email' class='form-control' id='newTmin' aria-describedby='emailHelp'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-danger text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Tensão Máxima</label>"
//								+ "<label for='exampleInputEmail1' id='tMax'>"+ machine.tMax+" V</label>"
								+ "<input type='email' class='form-control' id='newTmax' aria-describedby='emailHelp'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='row'>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-primary text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Corrente Mínima</label>"
//								+ "<label for='exampleInputEmail1' id='cMin'>"+ machine.cMin+" I</label>"
								+ "<input type='email' class='form-control' id='newCmin' aria-describedby='emailHelp'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-danger text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Corrente Máxima</label>"
//								+ "<label for='exampleInputEmail1' id='cMax'>"+ machine.cMax+" I</label>"
								+ "<input type='email' class='form-control' id='newCmax' aria-describedby='emailHelp'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='row'>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-primary text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Temp. Mínima</label>"
//								+ "<label for='exampleInputEmail1' id='tempMin'>"+ machine.tempMin+" °C</label>"
								+ "<input type='email' class='form-control' id='newTempMin' aria-describedby='emailHelp'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='col-lg-6 mb-4'>"
								+ "<div class='card bg-danger text-white'>"
								+ "<div class='card-body'>"
								+ "<label for='exampleInputEmail1'>Temp. Máxima</label>"
//								+ "<label for='exampleInputEmail1' id='tempMax'>"+ machine.tempMax+" °C</label>"
								+ "<input type='email' class='form-control' id='newTempMax' aria-describedby='emailHelp' placeholder='"+ machine.tempMax+"'>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "<div class='modal-footer'>"
								+ "<button type='button' id='closeModal' class='btn btn-outline-primary' data-dismiss='modal'>Fechar</button>"
								+ "<button type='button' class='btn btn-primary' onclick=PREDICT.machine.editMachine("
								+ machine.idMachine
								+ ")>Salvar alterações</button>"
								+ "</div>"
								+ "</form></div>"
								+ "</div>"
								+ "</div>" + "</div>" + "</div>"

						console.log(machine.idMachine)
						return modal;
					}
					
					PREDICT.machine.editMachine = function(idMachine){
						var machine = new Object()
						machine.idMachine = idMachine
						machine.name = document.formEditMachine.newName.value;
						machine.descriptionMachine = document.formEditMachine.newDescription.value;
						machine.tMin = document.formEditMachine.newTmin.value;
						machine.tMax = document.formEditMachine.newTmax.value;
						machine.cMin = document.formEditMachine.newCmin.value;
						machine.cMax = document.formEditMachine.newCmax.value;
						machine.tempMin = document.formEditMachine.newTempMin.value;
						machine.tempMax = document.formEditMachine.newTempMax.value;
						machine.typeMachine_idType = document.formEditMachine.idType.value;
						console.log(machine)
						
						$.ajax({
							type : "POST",
							url : PREDICT.PATH + "machine/editMachine",
							data : JSON.stringify(machine),
							success : function (msg){
								alert(msg)
								
							},
							error : function (msg){
								alert(msg)
							}
							});
					}

				})// End documento and function
