// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios()
  $('#usuarios').DataTable();
});

// Request fetch de usuarios que seria un AJAX, esta funcion nos devuelve la list de usuarios JSON //
async function cargarUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

 // Listado de usuarios //
  let listadoHTML = "";

// Este foreach se usara para asignar la info en cada usuario autom. Toda esa info la metemos en usuarioHTML, y luego esa var la metemos en listadoHTML
  for(usuario of usuarios){
    let botonEliminar = '<a href="#" onclick = "eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    //Nos pinta en la tabla todos los users autm. //
    let usuarioHTML = '<tr><td>' + usuario.id +'</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email +'</td><td>'
    + usuario.telefono +'</td><td>' + botonEliminar + ' </td></tr>'

    listadoHTML += usuarioHTML;
 }
  document.querySelector("#usuarios tbody").outerHTML = listadoHTML;
}

 async function eliminarUsuario(id){
 if(!confirm('Do you want to delete this user?')){
   return;
 }
  const request = await fetch('api/usuarios/' + id, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });

    location.reload();
}
