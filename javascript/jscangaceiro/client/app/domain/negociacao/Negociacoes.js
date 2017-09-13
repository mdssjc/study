// client/app/domain/negociacao/Negociacoes.js

class Negociacoes {

  constructor() {
    this._negociacoes = [];
  }

  adiciona(negociacao) {
    this._negociacoes.push(negociacao);
  }

  paraArray() {
    return this._negociacoes;
  }
}
