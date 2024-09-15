document.addEventListener("DOMContentLoaded", () => {
  const inputMarca = document.getElementById("marca");
  const datalistMarcas = document.getElementById("marcas");
  const botaoBuscar = document.getElementById("buscar");
  const listaModelos = document.getElementById("modelos");
  const mensagemErro = document.getElementById("mensagem");

  async function carregarMarcas() {
    try {
      const resposta = await fetch(
        "https://parallelum.com.br/fipe/api/v1/carros/marcas"
      );
      const marcas = await resposta.json();

      marcas.forEach((marca) => {
        const opcao = document.createElement("option");
        opcao.value = marca.nome;
        opcao.dataset.id = marca.codigo;
        datalistMarcas.appendChild(opcao);
      });
    } catch (erro) {
      mensagemErro.textContent = "Erro ao carregar as marcas. Tente novamente.";
    }
  }

  async function buscarModelos() {
    const marcaSelecionada = inputMarca.value;
    const marcaCorrespondente = Array.from(datalistMarcas.options).find(
      (opcao) => opcao.value === marcaSelecionada
    );

    if (!marcaCorrespondente) {
      mensagemErro.textContent =
        "Marca não encontrada. Selecione uma marca válida.";
      return;
    }

    const idMarca = marcaCorrespondente.dataset.id;

    try {
      const resposta = await fetch(
        `https://parallelum.com.br/fipe/api/v1/carros/marcas/${idMarca}/modelos`
      );
      const dados = await resposta.json();
      const modelos = dados.modelos;

      listaModelos.innerHTML = "";
      if (modelos.length === 0) {
        mensagemErro.textContent = "Nenhum modelo encontrado para esta marca.";
      } else {
        mensagemErro.textContent = "";

        modelos.forEach((modelo) => {
          const itemLista = document.createElement("li");
          itemLista.textContent = modelo.nome;
          listaModelos.appendChild(itemLista);
        });
      }
    } catch (erro) {
      mensagemErro.textContent = "Erro ao buscar os modelos. Tente novamente.";
    }
  }

  carregarMarcas();

  botaoBuscar.addEventListener("click", buscarModelos);
});
