function derivar(sentencaInput) {
  var sentenca = separarSentenca(sentencaInput);

  var resultado = "";
  var derivacoes = "";
  var letra = "S";
  var pilha = [];
  const a = Math.floor(Math.random() * sentenca[letra].length);
  var aux = sentenca[letra][a];

  for (var i = aux.length - 1; i >= 0; i--) {
    pilha.push(aux[i]);
  }

  while (pilha.length != 0) {
    var test = "";

    for (var i = pilha.length - 1; i >= 0; i--) {
      test += pilha[i];
    }

    var ab = pilha.pop();

    if (sentenca[ab] != undefined) {
      letra = ab;
      const a = Math.floor(Math.random() * sentenca[letra].length);
      var aux = sentenca[letra][a];
      for (var i = aux.length - 1; i >= 0; i--) {
        pilha.push(aux[i]);
      }
      console.log("montando: " + resultado + test); // pegar aqui pra mostrar na tela
      derivacoes += resultado + test + "<br>";
    } else {
      resultado += ab;
    }
  }
  console.log("final: " + resultado); // só teste, ignore
  return { resultado, derivacoes };
}

function separarSentenca(sentencaInput) {
  var sentenca = sentencaInput.trim();
  const sep = sentenca.split(";");

  var sentencaSep = new Object();

  for (var i = 0; i < sep.length; i++) {
    const letra = sep[i].split("=");
    const derivacoes = letra[1].split("|");
    sentencaSep[letra[0]] = derivacoes;
  }

  return sentencaSep;
}

function buttonClick() {
  const input = document.querySelector("input#input").value;
  const inputSpan = document.querySelector("span#sentencaInput");

  if (input == "") return;

  const results = document.querySelector("#resultInput");
  results.innerHTML = "";
  inputSpan.innerHTML = "";

  const { resultado, derivacoes } = derivar(input);

  inputSpan.appendChild(document.createTextNode(input));

  mostrarResultado("resultInput", derivacoes, resultado);
}

function mostrarResultado(idResult, derivacoes, resultado) {
  const results = document.querySelector(`#${idResult}`);

  const derivacoesDiv = document.createElement("div");
  derivacoesDiv.setAttribute("class", "result");
  derivacoesDiv.innerHTML = derivacoes;
  results.appendChild(derivacoesDiv);

  const resultDiv = document.createElement("div");
  resultDiv.setAttribute("class", "result");
  resultDiv.appendChild(document.createTextNode(resultado));
  results.appendChild(resultDiv);
}

function derivarExemplos() {
  const exemplo1 = document.querySelector("span#exemplo1").textContent;
  const exemplo2 = document.querySelector("span#exemplo2").textContent;
  const exemplo3 = document.querySelector("span#exemplo3").textContent;

  const { resultado: resultado1, derivacoes: derivacoes1 } = derivar(exemplo1);
  const { resultado: resultado2, derivacoes: derivacoes2 } = derivar(exemplo2);
  const { resultado: resultado3, derivacoes: derivacoes3 } = derivar(exemplo3);

  mostrarResultado("resultExemplo1", derivacoes1, resultado1);
  mostrarResultado("resultExemplo2", derivacoes2, resultado2);
  mostrarResultado("resultExemplo3", derivacoes3, resultado3);
}

derivarExemplos();
