const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Digite os números separados por espaço: ", (input) => {
  const args = input.split(" ");

  const sum = args
    .map(Number)
    .filter((num) => !isNaN(num) && num % 2 === 0)
    .reduce((acc, curr) => acc + curr, 0);

  console.log(sum);
  rl.close();
});
