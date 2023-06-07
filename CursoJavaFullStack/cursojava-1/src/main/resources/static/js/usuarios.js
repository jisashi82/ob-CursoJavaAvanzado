// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
  EncontrarUsuario();
});


function EncontrarUsuario(){
	document.getElementById("txt-usuario-email").outerHTML=localStorage.email
}


async function cargarUsuarios(params) {
 
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: getHeaders()
    });
    const usuarios = await request.json();

    let listadoHTML='';

    for(let usuario of usuarios) {
      let usuarioHTML= `
      <tr>
                      <td>${usuario.id}</td>
                      <td>${usuario.nombre} ${usuario.apellido}</td>
                      <td>${usuario.email}</td>
                      <td>${usuario.telefono}</td>
                      <td>
                        <a href="#" onclick="eliminarUsuario(${usuario.id})" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>
                      </td>
                    </tr>
      `;
      listadoHTML +=  usuarioHTML;
    };

    
    console.log(usuarios);
    //console.log(listadoHTML);
    document.querySelector('#usuarios tbody').outerHTML = listadoHTML
  
}

async function eliminarUsuario(id){
	
	if(!confirm('¿Desea eliminar el usuario?')){
		return;
	}
	
	await fetch('api/usuarios/'+id, {
      method: 'DELETE',
      headers: {
        'Accept': getHeaders()
      }
    });
    location.reload()
	
}

function getHeaders(){
	return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization':localStorage.token
      }
}