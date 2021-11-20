PREDICT.typeMachine = new Object();

$(document)
		.ready(
				function() {

					PREDICT.typeMachine.typeEdit = function(idType) {

						var typeMachine = new Object();
						typeMachine.idType = idType;
						typeMachine.name = document.getElementById("newName").value;
						typeMachine.descriptionType = document
								.getElementById("newDescription").value;

						console.log(typeMachine)
						$.ajax({
							type : "POST",
							url : PREDICT.PATH + "type/typeEdit",
							data : JSON.stringify(typeMachine),
							success : function(msg) {
								alert(msg)
								document.getElementById("closeModal").click()
								PREDICT.typeMachine.searchRegistryType()
							},
							error : function(msg) {
								alert("Erro ao excluir tipo de equipamento.")
							}

						})

					}

					PREDICT.typeMachine.typeModalEdit = function(idType) {

						$("#editType").html(PREDICT.typeMachine.buildModalEdit(idType));

					}

					PREDICT.typeMachine.buildModalEdit = function(idType) {

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
								+ "<form>"
								+ "<div class='card-header py-3 d-flex flex-row align-items-center justify-content-between'>"
								+ "</div>"
								+ "<div class='form-group'>"
								+ "<label for='exampleInputEmail1'>Nome</label>"
								+ "<input type='email' class='form-control' id='newName' aria-describedby='emailHelp' placeholder='Informe o novo nome tipo de equipamento'>"
								+ "<small id='emailHelp' class='form-text text-muted'></small>"
								+ "</div>"
								+ "<div class='form-group'>"
								+ "<label for='exampleFormControlTextarea1'>Descrição</label>"
								+ "<textarea class='form-control' id='newDescription' rows='3' placeholder='Informe a nova descrição referente ao tipo de equipamento'></textarea>"
								+ "</div>"
								+ "<div class='modal-footer'>"
								+ "<button type='button' id='closeModal' class='btn btn-outline-primary' data-dismiss='modal'>Fechar</button>"
								+ "<button type='button' class='btn btn-primary' onclick=PREDICT.typeMachine.typeEdit(" + idType + ")>Salvar alterações</button>"
								+ "</div>"
								+ "</form></div>"
								+ "</div>"
								+ "</div>" + "</div>" + "</div>"
								console.log(idType)
						return modal;
					}

					PREDICT.typeMachine.typeDelete = function(idType) {

						$.ajax({
							type : "DELETE",
							url : PREDICT.PATH + "type/typeDelete/" + idType,
							success : function(msg) {
								alert(msg)
								PREDICT.typeMachine.searchRegistryType()
							},
							error : function(msg) {
								alert("Erro ao excluir tipo de equipamento.")
							}

						})

					}

					PREDICT.typeMachine.searchRegistryType = function() {

						$
								.ajax({
									type : "GET",
									url : PREDICT.PATH
											+ "type/searchRegistryType",
									success : function(listTypeMachine) {
										$('#listTypeMachine')
												.html(
														PREDICT.typeMachine
																.buildTable(listTypeMachine))
									},
									error : function(listTypeMachine) {
										alert("Erro ao buscar tipos de equipamentos cadastrados.")
									}

								})
					}

					PREDICT.typeMachine.buildTable = function(listTypeMachine) {

						var table = "<table class='table align-items-center table-flush'>"
								+ "<thead class='thead-light'>"
								+ "<tr>"
								+ "<th>Tipo</th>"
								+ "<th>Descrição</th>"
								+ "<th>Opções</th>"
								+ "</tr>"
								+ "</thead>"
								+ "<tbody>";

						if (listTypeMachine.length > 0) {
							/*
							 * TODO: Substituir for por forEach
							 */
							for (var i = 0; i < listTypeMachine.length; i++) {
								table += "<tr><td>"
										+ listTypeMachine[i].name
										+ "</td>"
										+ "<td>"
										+ listTypeMachine[i].descriptionType
										+ "</td>"
										+ "<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModal' id='#myBtn' onclick=PREDICT.typeMachine.typeDelete("
										+ listTypeMachine[i].idType
										+ ")>Excluir</button>"
										+ "<button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModalScrollable' id=#modalScroll' onclick=PREDICT.typeMachine.typeModalEdit("
										+ listTypeMachine[i].idType
										+ ")>Editar</button></td></tr>"
							}

						} else if (listTypeMachine == "") {
							tabela += "<tr><td>Nenhum registro encontrado</td></tr>";
						}
						table += "</tbody></table>"

						return table;
					}

					PREDICT.typeMachine.searchRegistryType()

				})// Fim document e function
