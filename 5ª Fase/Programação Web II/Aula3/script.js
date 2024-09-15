async function fetchSuperheroes() {
  try {
    const response = await fetch(
      "https://akabab.github.io/superhero-api/api/all.json"
    );
    const data = await response.json();
    return data;
  } catch (error) {
    console.error("Erro ao buscar dados dos super-heróis:", error);
  }
}

function formatAlterEgos(superheroes) {
  return superheroes
    .map(
      (hero) => `
      <div class="hero-item">
        <h3>${hero.name}</h3>
        <span>${hero.biography.alterEgos}</span>
      </div>
    `
    )
    .join("");
}

function calculateTotalFirstAppearanceLength(superheroes) {
  return superheroes.reduce((total, hero) => {
    if (hero.biography.publisher === "Marvel Comics") {
      return (
        total +
        (hero.biography.firstAppearance
          ? hero.biography.firstAppearance.length
          : 0)
      );
    }
    return total;
  }, 0);
}

function getDCComicsCharacterNames(superheroes) {
  return superheroes
    .filter((hero) => hero.biography.publisher === "DC Comics")
    .map((hero) => hero.name);
}

function sortHeroesByNameLength(superheroes) {
  return superheroes.sort((a, b) => a.name.length - b.name.length);
}

async function main() {
  const superheroes = await fetchSuperheroes();

  document.getElementById("alterEgosOutput").innerHTML =
    formatAlterEgos(superheroes);
  document.getElementById("totalFirstAppearanceLengthOutput").textContent =
    calculateTotalFirstAppearanceLength(superheroes);
  document.getElementById("dcComicsCharactersOutput").textContent =
    JSON.stringify(getDCComicsCharacterNames(superheroes), null, 2);
  document.getElementById("sortedByNameLengthOutput").textContent =
    JSON.stringify(
      sortHeroesByNameLength(superheroes).map((hero) => hero.name),
      null,
      2
    );
}

function showSection(sectionId) {
  const sections = document.querySelectorAll(".section");
  sections.forEach((section) => (section.style.display = "none"));
  document.getElementById(sectionId).style.display = "block";
}

main();
