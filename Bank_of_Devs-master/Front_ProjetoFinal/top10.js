function iniciar(){
    let user = localStorage.getItem("usuarioLogado");
    if(!user){//usuario nao fez login
        window.location = "loginEmail.html";
    }

    let nomeUsuario = JSON.parse(user).nome;
    let racfUsuario = JSON.parse(user).racf;
    let foto = JSON.parse(user).foto;
    console.log(foto);
    document.getElementById("user").innerHTML = nomeUsuario+" ("+racfUsuario+")";

    var img = document.createElement("img");
    img.src = foto;
    var src = document.getElementById("foto");
    src.appendChild(img);
    carregarDados();

}

function logout(){
    localStorage.removeItem("usuarioLogado");
    window.location = "loginEmail.html";
}

function carregarDados(){
    fetch("http://localhost:8080/parceiro").then(res => res.json())
    .then(res => preencher(res));
}

function preencher(res){
    let tabela=`<table class=" table table-sm"> 
                <tr> 
                    <th class="text_table">ID</th> 
                    <th class="text_table">Nome</th> 
                    <th class="text_table">Volume transacional</th>
                </tr>`;
    let combo = `<select style="width:auto;margin:0px" onchange="dropdowm()" class="form-control" id="dropdownMenuLink">
    <option>Parceiro</option>`;
for(let index = 0;index < res.length;index++){
    tabela = tabela +`<tr> 
                        <td class="text1">  ${res[index].idParceiro} </td> 
                        <td class="text1"> ${res[index].nome_agente}</td> 
                        <td class="text1"> ${res[index].volumeTransacional} </td>
                    </tr>`;
    combo = combo + `<option value="${res[index].idParceiro}">${res[index].nome_agente}</option>`;
}
    tabela = tabela +"</table>";
    combo  = combo + "</select>";
    document.getElementById("conteudo").innerHTML = tabela;
    document.getElementById("combo").innerHTML = combo;
}
//funcao para o dropdowm
function dropdowm() {
    let objselecao = document.getElementById("dropdownMenuLink");
    let valor = objselecao.options[objselecao.selectedIndex].value;
    localStorage.setItem("parceiroSelecionado",JSON.stringify(valor));
    window.location = "parceiro.html"; 

}
 