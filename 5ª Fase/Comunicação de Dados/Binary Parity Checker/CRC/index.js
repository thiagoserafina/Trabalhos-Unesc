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

function showMenu() {
  menu.question(
    "O que deseja fazer?\n1 - Transmitir \n2 - Verificar \n0 - Sair\n\nSua opção: ",
    (opcao) => {
      console.log("");
      switch (opcao) {
        case "1":
          menu.question(
            "Digite a palavra que deseja transmitir: ",
            (palavra) => {
              const palavraBinaria = converterParaBinario(palavra);
              const palavraBinariaComCRC = adicionarCRC(
                palavraBinaria,
                gerador
              );
              gravarNoArquivo(palavraBinariaComCRC);
              console.log(`\nResultado: ${palavraBinariaComCRC}`);
              console.log("Arquivo criado com sucesso!");
              menu.question("\nPressione Enter para continuar...", () => {
                console.clear();
                showMenu();
              });
            }
          );
          break;

        case "2":
          verificarCRC("./CRC.txt", gerador, () => {
            menu.question("\nPressione Enter para continuar...", () => {
              console.clear();
              showMenu();
            });
          });
          break;

        case "0":
          menu.question(
            "\nO programa irá fechar agora!\nPressione Enter para continuar...",
            () => {
              menu.close();
            }
          );
          break;

        default:
          menu.question(
            "\nOpção inválida!\nPressione Enter para continuar...",
            () => {
              console.clear();
              showMenu();
            }
          );
          break;
      }
    }
  );
}

showMenu();

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
  fs.writeFile("./CRC.txt", dados, (erro) => {
    if (erro) {
      console.error(`Erro ao criar arquivo: ${erro.message}`);
      return;
    }
  });
}

// Verifica se os dados foram corrompidos
function verificarCRC(arquivo, gerador, callback) {
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
    const corrompido = restos.some((resto) => resto.includes("1"));

    if (corrompido) {
      console.log("A mensagem foi corrompida!");
    } else {
      console.log("A mensagem não foi corrompida!");
    }

    callback();
  });
}
