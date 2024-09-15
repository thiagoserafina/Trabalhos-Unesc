const apiMegaSena =
  "https://loteriascaixa-api.herokuapp.com/api/megasena/latest";

let ultimoResultado = [];
let bilhetes = [];

async function buscarUltimoResultado() {
  try {
    const resposta = await fetch(apiMegaSena);
    const dados = await resposta.json();
    ultimoResultado = dados.dezenas.map(Number);
    console.log("Último resultado da Mega-Sena:", ultimoResultado);
  } catch (erro) {
    console.error("Erro ao buscar o resultado do último sorteio:", erro);
  }
}

function adicionarBilhete(evento) {
  evento.preventDefault();
  const numerosBilhete = document
    .getElementById("numeros")
    .value.split(",")
    .map(Number)
    .filter((num) => num >= 1 && num <= 60);

  if (numerosBilhete.length !== 6) {
    alert("Um bilhete deve conter exatamente 6 números entre 1 e 60.");
    return;
  }

  bilhetes.push(numerosBilhete);
  exibirBilhetes();
}

function exibirBilhetes() {
  const listaBilhetes = document.getElementById("listaBilhetes");
  listaBilhetes.innerHTML = "";
  bilhetes.forEach((bilhete, index) => {
    const itemLista = document.createElement("li");
    itemLista.textContent = `Bilhete ${index + 1}: ${bilhete.join(", ")}`;
    listaBilhetes.appendChild(itemLista);
  });
}

function realizarSorteio() {
  const elementoResultado = document.getElementById("resultado");
  const ganhadores = bilhetes.filter((bilhete) =>
    bilhete.every((numero) => ultimoResultado.includes(numero))
  );
  if (ganhadores.length > 0) {
    elementoResultado.textContent = `Temos ${ganhadores.length} ganhador(es)!`;
  } else {
    elementoResultado.textContent = "Nenhum ganhador.";
  }
}

document.addEventListener("DOMContentLoaded", () => {
  buscarUltimoResultado();

  document
    .getElementById("formularioBilhete")
    .addEventListener("submit", adicionarBilhete);
  document
    .getElementById("botaoSorteio")
    .addEventListener("click", realizarSorteio);
});
