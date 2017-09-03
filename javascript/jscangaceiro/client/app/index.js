// client/app/index.js

var campos = [
    document.querySelector('#data'),
    document.querySelector('#valor'),
    document.querySelector('#quantidade')
];

console.log(campos);

var tbody = document.querySelector('table tbody');

document.querySelector('.form')
    .addEventListener('submit',
                      function(event) {
                          alert('oi');
                      });
