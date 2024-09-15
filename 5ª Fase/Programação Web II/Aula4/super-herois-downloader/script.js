const readline = require("readline");
const axios = require("axios");
const fs = require("fs").promises;
const path = require("path");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function isNumberValid(number) {
  return Number.isInteger(number) && number >= 1 && number <= 999;
}

async function main() {
  const numbers = await new Promise((resolve) => {
    rl.question(
      "Digite os números dos super-heróis separados por espaço (de 1 a 999): ",
      (input) => {
        const nums = input.split(" ").map((num) => parseInt(num, 10));
        if (nums.every(isNumberValid)) {
          console.log("Números válidos recebidos:", nums);
          rl.close();
          resolve(nums);
        } else {
          console.error(
            "Erro: Entrada inválida. Certifique-se de digitar números entre 1 e 999."
          );
          rl.close();
          process.exit(1);
        }
      }
    );
  });

  if (numbers.length > 0) {
    async function fetchHeroData(numbers) {
      const heroData = [];
      for (const number of numbers) {
        try {
          const response = await axios.get(
            `https://akabab.github.io/superhero-api/api/id/${number}.json`
          );
          const { id, name, slug, appearance, images } = response.data;
          heroData.push({
            id,
            name,
            slug,
            race: appearance.race,
            image: images.md,
          });
          console.log(
            `Super-herói encontrado - ID: ${id}, Nome: ${name}, Slug: ${slug}, Raça: ${appearance.race}, Imagem: ${images.md}`
          );
        } catch (error) {
          console.error(
            `Falha ao buscar dados para o super-herói com ID ${number}:`,
            error.message
          );
        }
      }
      return heroData;
    }

    async function ensureDirectoryExists(dirPath) {
      try {
        await fs.access(dirPath);
      } catch {
        await fs.mkdir(dirPath, { recursive: true });
      }
    }

    async function saveHeroData(heroData) {
      const dirPath = path.join(__dirname, "superheroes");
      await ensureDirectoryExists(dirPath);

      for (const hero of heroData) {
        const filePath = path.join(dirPath, `${hero.id}.json`);
        try {
          await fs.writeFile(filePath, JSON.stringify(hero, null, 2));
          console.log(
            `Dados do super-herói ID ${hero.id} salvos em ${filePath}`
          );
        } catch (error) {
          console.error(
            `Falha ao salvar dados para o super-herói com ID ${hero.id}:`,
            error.message
          );
        }
      }
    }

    const heroData = await fetchHeroData(numbers);
    if (heroData.length > 0) {
      await saveHeroData(heroData);
    }
  }
}

main();
