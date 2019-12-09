// Step 1
// Step 2
// Step 3
const sayHello1 = (name, phrase = 'Hi') => console.log(`${phrase} ${name}`);
const sayHello2 = () => console.log('Hi Marcelo');
const sayHello3 = name => 'Hi ' + name;

sayHello1('Marcelo', 'Hi');
sayHello2();
console.log(sayHello3('Marcelo'));
sayHello1('Marcelo');

// Step 4
function checkInput(cb, ...args) {
  let hasEmpty = false;

  for (const arg of args) {
    if (!arg) {
      hasEmpty = true;
      break;
    }
  }

  if (hasEmpty) {
    cb();
  }
}

checkInput(() => console.log('All right!'), 'abc', 'bcd', 'cde');
checkInput(() => console.log('All right!'), 'abc', '', 'cde');
