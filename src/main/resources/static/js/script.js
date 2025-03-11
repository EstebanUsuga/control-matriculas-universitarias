function sumarCreditos(){

    let checkboxes = document.querySelectorAll('input[type="checkbox"]:checked[data-creditos]');
    const btnGuardar = document.getElementById('btn-guardar-materias');
    btnGuardar.disabled = false;
    let creditos = 0.0;

    checkboxes.forEach(checkbox => {
            creditos += parseFloat(checkbox.getAttribute('data-creditos'));
    });

    if(creditos >= 22){
        btnGuardar.disabled = true;
    }

    document.getElementById('total-creditos').innerHTML = creditos;
}