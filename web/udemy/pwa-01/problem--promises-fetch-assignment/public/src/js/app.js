var button = document.querySelector('#start-button');
var output = document.querySelector('#output');

button.addEventListener('click', () => {
  let promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('https://swapi.co/api/people/1');
    }, 3000);
  });

  promise
    .then(url => {
      return fetch(url);
    })
    .then(response => {
      return response.json();
    })
    .then(data => {
      output.textContent = data.name;
    });

  promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('https://httpbin.org/put');
    }, 3000);
  });

  promise
    .then(url => {
      return fetch(url, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
        mode: 'cors',
        body: JSON.stringify({ person: { name: 'Max', age: 28 } }),
      });
    })
    .then(response => {
      return response.json();
    })
    .then(data => {
      // output.textContent = data.json.person.name;
      let person = data.json.person;
      console.log(person.name, person.age);
    });

  promise
    .then(url => {
      return fetch(url + 'ops');
    })
    .then(response => {
      return response.json();
    })
    .then(
      data => {
        output.textContent = data.name;
      },
      err => {
        console.error('Ops', err);
      },
    );

  promise
    .then(url => {
      return fetch(url + 'ops');
    })
    .then(response => {
      return response.json();
    })
    .then(data => {
      output.textContent = data.name;
    })
    .catch(err => {
      console.error('Ops', err);
    });
});
