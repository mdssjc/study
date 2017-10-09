// client/app/util/ConnectionFactory.js

const stores = ['negociacoes'];

class ConnectionFactory {

  constructor() {
    throw new Error('Não é possível criar instâncias dessa classe');
  }

  static getConnection() {
    return new Promise((resolve, reject) => {
      const openRequest = indexedDB.open('jscangaceiro', 2);

      openRequest.onupgradeneeded = e => {
        stores.forEach(store => {

        });
      };
      openRequest.onsuccess = e => { };
      openRequest.onerror = e => { };
    });
  };
}
