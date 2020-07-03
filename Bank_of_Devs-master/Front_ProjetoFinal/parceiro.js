function iniciar(){
    let parceiro = localStorage.getItem("parceiroSelecionado");
    let user = localStorage.getItem("usuarioLogado");
    if(!user){//usuario nao fez login
        window.location = "loginEmail.html";
    }
    CountnSucesso();
}
function logout(){
    localStorage.removeItem("parceiroSelecionado");
    localStorage.removeItem("usuarioLogado");
    window.location = "loginEmail.html";
}
function CountnSucesso(){   
    let parceiro = localStorage.getItem("parceiroSelecionado");
    parceiro = JSON.parse(parceiro);
    fetch(`http://localhost:8080/parceiroselec?idParceiro=${parceiro}`)
    .then(res => res.json())
    .then(res => contador(res));     
}
function contador(res){
    let lista = res.listaTransacao;
    let contsucesso=0;
    let contfraude=0;
    let contfalha=0;
    for(let i = 0;i<lista.length;i++){
        switch(lista[i].status){
            case "0":
                contsucesso++;
                break;
            case "1":
                contfalha++;
                break;
            case "2":
                contfraude++;
                break;
        }
    }
    let nomeAgente = res.nome_agente; 
    document.getElementById("parceiro").innerHTML = nomeAgente;
    document.getElementById("sucesso").innerHTML = contsucesso; 
    document.getElementById("falha").innerHTML = contfalha; 
    document.getElementById("fraude").innerHTML = contfraude; 
}
function voltar(){
    window.location = "top10.html";
    }