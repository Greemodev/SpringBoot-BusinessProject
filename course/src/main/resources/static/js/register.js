// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});

// Request fetch de usuarios que seria un AJAX, esta funcion nos devuelve la list de usuarios JSON //
async function registerUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();
}


