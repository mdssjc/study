// client/app/controllers/NegociacaoController.js

class NegociacaoController {

  constructor() {
    let $ = document.querySelector.bind(document);

    this._inputData = $('#data');
    this._inputQuantidade = $('#quantidade');
    this._inputValor = $('#valor');
    this._negociacoes = new Negociacoes();
  }

  adiciona(event) {
    event.preventDefault();

    let negociacao = new Negociacao(
      DateConverter.paraData(this._inputData.value),
      parseInt(this._inputQuantidade.value),
      parseFloat(this._inputValor.value)
    );

    this._negociacoes.adiciona(negociacao);

    console.log(this._negociacoes.paraArray());
  }
}
