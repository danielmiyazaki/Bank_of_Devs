function acessarEmail(event) {
    event.preventDefault();

    let inputEmail = document.getElementById("inputEmail").value;
    let inputSenha = document.getElementById("inputSenha").value;
    let loginMsg;

    /* alert(inputEmail + " - " + inputSenha); */
    if (checarEmail(inputEmail)){
        loginMsg = {        
            email: inputEmail,
            senha: inputSenha
        }
    }else{
        loginMsg = {        
            racf: inputEmail,
            senha: inputSenha
        }
    }
    
    let cabecalho = {
        method: "POST",
        body: JSON.stringify(loginMsg),
        headers:{
            'Content-type':'application/json'
        }
    }
    fetch("http://localhost:8080/login", cabecalho).then(res => trataResposta(res))
}

function trataResposta(res){
    
    if(res.status==200){//success
        /* document.getElementById("msgError").innerHTML = "Sucesso!"; */
        res.json().then(res => logarUsuario(res));
        window.location = "top10.html"
    }else{
        document.getElementById("msgError").innerHTML = "Usuário/Login inválido!";
    }
}

function logarUsuario(res){
    localStorage.setItem("usuarioLogado",JSON.stringify(res));
    }
    
function checarEmail(campoEmail) {
    if (campoEmail == "" || campoEmail.indexOf('@') == -1 || campoEmail.indexOf('.') == -1) 
    {
        return false;
    }
    return true;
}

