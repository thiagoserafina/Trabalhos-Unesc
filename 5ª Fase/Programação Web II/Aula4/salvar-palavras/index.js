const fs = require("fs");
const readlineSync = require("readline-sync");

function solicitarPalavras() {
  const palavras = new Set();

  while (true) {
    const palavra = readlineSync
      .question("Digite uma palavra (ou deixe em branco para finalizar): ")
      .trim();

    if (palavra === "") {
      break;
    }

    if (palavra && !palavras.has(palavra)) {
      palavras.add(palavra);
    }
  }

  return Array.from(palavras);
}

function main() {
  const palavras = solicitarPalavras();

  fs.writeFile(
    "palavras.json",
    JSON.stringify(palavras, null, 2),
    { encoding: "utf8" },
    (err) => {
      if (err) {
        console.error("Erro ao salvar as palavras:", err);
      } else {
        console.log("Palavras salvas com sucesso em palavras.json");
      }
    }
  );
}

main();
