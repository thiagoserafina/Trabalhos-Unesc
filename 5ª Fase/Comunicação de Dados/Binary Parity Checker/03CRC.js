// ###################################
// #
// # UNESC
// # CIÊNCIA DA COMPUTAÇÃO
// # COMUNICAÇÃO DE DADOS
// # 2023/06
// # PROF.: VALTER BLAUTH JUNIOR
// # ALUNO: THIAGO SERAFINA POSSAMAI
// #
// ###################################

const readline = require("readline");
const fs = require("fs");

const gerador = "101101";
const menu = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

menu.question(
  "O que deseja fazer? (1 - Transmitir / 2 - Verificar): ",
  (opcao) => {
    console.log("");
    switch (opcao) {
      case "1":
        menu.question("Digite a palavra que deseja transmitir: ", (palavra) => {
          const palavraBinaria = converterParaBinario(palavra);
          const palavraBinariaComCRC = adicionarCRC(palavraBinaria, gerador);
          gravarNoArquivo(palavraBinariaComCRC);
          console.log(`\nResultado: ${palavraBinariaComCRC}`);

          menu.close();
        });
        break;

      case "2":
        verificarCRC("./03CRC.txt", gerador);

        menu.close();
        break;

      default:
        console.log("Opção inválida!");
        menu.close();
        break;
    }
  }
);

// Conversão do texto para binário
function converterParaBinario(palavra) {
  let binarioConvertido = "";

  for (let i = 0; i < palavra.length; i++) {
    const charCode = palavra.charCodeAt(i);
    const binario = charCode.toString(2).padStart(9, "0");

    binarioConvertido += binario + " ";
  }

  return binarioConvertido.trim();
}

// Adiciona o CRC no final da palavra binária
function adicionarCRC(binario, gerador) {
  const arrayBinario = binario.split(" ");
  const resultadosCRC = [];

  for (let binario of arrayBinario) {
    const binarioMaisZeros = binario + "0".repeat(gerador.length - 1);
    let resto = binarioMaisZeros;

    for (let i = 0; i < binario.length; i++) {
      if (resto[i] === "1") {
        let temp = "";
        for (let j = 0; j < gerador.length; j++) {
          temp += resto[i + j] === gerador[j] ? "0" : "1";
        }
        resto = resto.slice(0, i) + temp + resto.slice(i + gerador.length);
      }
    }

    const crc = resto.slice(-gerador.length + 1);
    resultadosCRC.push(binario + crc);
  }
  return resultadosCRC.join(" ");
}

// Grava a palavra binária com o CRC no arquivo
function gravarNoArquivo(dados) {
  fs.writeFile("./03CRC.txt", dados, (erro) => {
    if (erro) {
      console.error(`Erro ao criar arquivo: ${erro.message}`);
      return;
    }
    console.log("Arquivo criado com sucesso!");
  });
}

// Verifica se os dados foram modificados
function verificarCRC(arquivo, gerador) {
  fs.readFile(arquivo, "utf8", (erro, dado) => {
    if (erro) {
      console.error(`Erro ao ler o arquivo: ${erro.message}`);
      return;
    }

    const dados = dado.split(" ");
    const restos = [];

    for (let item of dados) {
      const binario = item;
      let resto = binario;

      for (let i = 0; i < binario.length; i++) {
        if (resto[i] === "1") {
          let temp = "";
          for (let j = 0; j < gerador.length; j++) {
            temp += resto[i + j] === gerador[j] ? "0" : "1";
          }
          resto = resto.slice(0, i) + temp + resto.slice(i + gerador.length);
        }
      }

      restos.push(resto);
    }

    console.log("Restos: ", restos);
    const modificado = restos.some((resto) => resto.includes("1"));

    if (modificado) {
      console.log("A mensagem foi modificada!");
    } else {
      console.log("A mensagem não foi modificada!");
    }
  });
}
