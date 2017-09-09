// client/app/app.js

let controller = new NegociacaoController();

document
  .querySelector('.form')
  .addEventListener('submit', controller.adiciona.bind(controller));
