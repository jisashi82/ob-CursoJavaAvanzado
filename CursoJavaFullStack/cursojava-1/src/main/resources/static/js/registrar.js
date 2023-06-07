// Call the dataTables jQuery plugin
$(document).ready(function() {


});

async function registrarUsuarios() {

	//Obtiene los datos del formulario por #ID
	let datos = {}
	datos.nombre = document.getElementById('txtNombre').value
	datos.apellido = document.getElementById('txtApellido').value
	datos.telefono=document.getElementById('txtTelefono').value
	datos.email=document.getElementById('txtEmail').value
	datos.password=document.getElementById('txtPassword').value
	
	let repetirPassword=document.getElementById('txtRepetirPassword').value
	
	//valida que la contraseña sea igual en ambos cambos 
	if(repetirPassword != datos.password){
		alert('La contraseña no es igual');
		return;
	}
	
	//llamada al controller para guardar
	const request=await fetch('api/usuarios', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(datos)
	});
	const usuarios = await request.json();
	alert('Se ha registrado correctamente el usuario');
	window.location.href='usuarios.html';
}
