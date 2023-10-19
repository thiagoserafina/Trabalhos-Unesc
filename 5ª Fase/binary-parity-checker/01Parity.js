// ###################################
// #
// # UNESC
// # CIÊNCIA DA COMPUTAÇÃO
// # COMUNICAÇÃO DE DADOS
// # 2023/01
// # PROF.: VALTER BLAUTH JUNIOR
// # ALUNO: THIAGO SERAFINA POSSAMAI
// #
// ###################################

// Ao testar o código, por favor instale o node.js em sua máquina e execute o comando abaixo no terminal:
// node index.js

const readline = require("readline");
const fs = require("fs");

// Leitura da palavra digitada pelo usuário
const menu = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// Menu de opções
menu.question(
  "O que deseja fazer? (1 - Codificar / 2 - Verificar paridade): ",
  (option) => {
    console.log("");
    switch (option) {
      case "1":
        menu.question("Digite a palavra que deseja transmitir: ", (palavra) => {
          const palavraBinaria = convertBinario(palavra);
          const resultadoFinal = addParidade(palavraBinaria);
          gravaArquivo(resultadoFinal);
          menu.close();
        });
        break;
      case "2":
        verificaBitParidade();
        menu.close();
        break;
      default:
        console.log("Opção inválida!");
        menu.close();
        break;
    }
  }
);

// ###################################
// # OPÇÃO 1 = CODIFICAÇÃO
// ###################################

// Conversão da palavra digitada para binário
function convertBinario(palavra) {
  var binario = "";

  for (var i = 0; i < palavra.length; i++) {
    binario += palavra[i].charCodeAt(0).toString(2) + " ";
  }

  return binario.trim();
}

function addParidade(palavraBinaria) {
  var resultado = "";
  const palavras = palavraBinaria.split(" ");

  for (var i = 0; i < palavras.length; i++) {
    const palavra = palavras[i];
    const bitParidade = calcularParidade(palavra);
    resultado += palavra + " " + bitParidade + "\n";
  }

  const bitsParidadeColuna = calcularBitsParidadeColuna(palavras);
  const bitParidadeFinal = calcularParidade(bitsParidadeColuna);

  resultado += "\n" + bitsParidadeColuna + " " + bitParidadeFinal + "\n";

  return resultado.trim();
}

// Calculo do bit de paridade
function calcularParidade(palavra) {
  const contaUns = [...palavra].filter((bit) => bit === "1").length;
  const bitParidade = contaUns % 2 === 0 ? "0" : "1";
  return bitParidade;
}

// Calculo dos bits de paridade das colunas
function calcularBitsParidadeColuna(palavras) {
  var resultado = "";

  for (var i = 0; i < palavras[0].length; i++) {
    let contaUns = 0;
    for (var j = 0; j < palavras.length; j++) {
      if (palavras[j][i] === "1") {
        contaUns++;
      }
    }
    const bitParidadePosicao = contaUns % 2 === 0 ? "0" : "1";
    resultado += bitParidadePosicao;
  }

  return resultado;
}

// Geração do arquivo com o resultado final
function gravaArquivo(resultadoFinal) {
  const linhas = resultadoFinal.trim().split("\n");
  const resultadoFinalFormatado = linhas.join("\n");

  fs.writeFile("./01Parity.txt", resultadoFinalFormatado, (erro) => {
    if (erro) {
      console.error(`Erro ao criar arquivo: ${erro.message}`);
      return;
    }
    console.log("Arquivo criado com sucesso!");
  });
}

// ###################################
// # OPÇÃO 2 = VERIFICAÇÃO DO BIT DE PARIDADE
// ###################################

function verificaBitParidade() {
  // Leitura do arquivo gravado
  fs.readFile("./01Parity.txt", "utf8", (erro, dados) => {
    if (erro) {
      console.error(`Erro ao ler arquivo: ${erro.message}`);
      return;
    }

    const linhas = dados.trim().split("\n");
    var erros = 0; // Contador de erros

    // Verificação do bit de paridade linha por linha
    linhas.forEach((linha, index) => {
      const partes = linha.trim().split(" ");
      const palavra = partes[0];
      const bitParidade = partes[1];

      const bitsParidadeCalculado = calcularParidade(palavra);
      if (bitParidade !== bitsParidadeCalculado && bitParidade !== " ") {
        if (palavra === 0) {
          console.log(
            `Erro na palavra ${palavra} (linha ${
              index + 1
            }) - Bit de paridade deveria ser ${bitsParidadeCalculado}`
          );
          erros++;
        }
      }
    });

    // Verificação do bit de paridade final
    const ultimaLinha = linhas[linhas.length - 1];
    const partesUltimaLinha = ultimaLinha.trim().split(" ");
    const bitsParidadeColuna = calcularBitsParidadeColuna(linhas);
    const bitParidadeFinalCalculado = calcularParidade(bitsParidadeColuna);

    const bitParidadeFinal = partesUltimaLinha[1];
    if (
      bitParidadeFinal !== bitParidadeFinalCalculado &&
      bitParidadeFinal !== ""
    ) {
      console.log(
        `Erro no bit de paridade final - Bit esperado: ${bitParidadeFinalCalculado}`
      );
      erros++;
    }

    // Apenas se não houver erros
    if (erros === 0) {
      console.log("Nenhum erro de transmissão encontrado!");

      // Recalculate parity bits
      const bitsParidadeColunaRecalculados = calcularBitsParidadeColuna(linhas);
      const bitParidadeFinalRecalculado = calcularParidade(
        bitsParidadeColunaRecalculados
      );

      if (
        bitParidadeFinal !== bitParidadeFinalRecalculado &&
        bitParidadeFinal !== ""
      ) {
        console.log(
          "O bit armazenado no arquivo foi manipulado após a geração."
        );
      } else {
        console.log(
          "O bit armazenado no arquivo não foi manipulado após a geração."
        );
      }
    }
  });
}
