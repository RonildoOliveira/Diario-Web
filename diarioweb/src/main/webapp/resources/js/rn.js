function hideForm() {
	if( document.getElementById("comboSecao").length == 0){
		document.getElementById("formNot").style.display="none";
		alert('Sem Seções Cadastradas!');
	}
	else{
		document.getElementById("formNot").style.display="block";
	}
}
window.onload = hideForm;

/***************/

function formSecao() {
    alert("Seção cadastrada com sucesso!");
}

function formUsuario() {
    alert("Usuário cadastrado com sucesso!");
}