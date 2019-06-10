import { Identity } from './monads/identity';
import { List } from './monads/list';
import { Maybe } from './monads/maybe';

// Identity
const one = Identity.of(1);
const two = one.map(a => a + 1);

console.log(one.emit());
console.log(one.chain(a => a + 1));
console.log(one.map(a => a + 1));
console.log(two.inspect());

// List
const myNumbers = List.of([1, 3, 4, 7, 10]);

console.log(myNumbers.concat([12]).inspect());
console.log(myNumbers.head());
console.log(myNumbers.tail());

// Maybe
const fahrenheitToCelsius = a => (a - 32) * 0.5556;

const reading1 = 15;
const reading2 = null;

const display = a => {
    console.log(a);
    return a;
};

const temp1C = Maybe.of(reading1)
    .map(fahrenheitToCelsius)
    .inspect();
const temp2C = Maybe.of(reading2)
    .map(fahrenheitToCelsius)
    .inspect();

console.log(temp1C);
console.log(temp2C);

Maybe.of(reading1)
    .map(fahrenheitToCelsius)
    .fork(_ => display('ERR!'), t => display(`${t}°C`));
Maybe.of(reading2)
    .map(fahrenheitToCelsius)
    .fork(_ => display('ERR!'), t => display(`${t}°C`));
const temp3C = Maybe.of(reading1)
    .map(fahrenheitToCelsius)
    .fork(_ => display('ERR!'), t => display(`${t}°C`));

console.log(temp3C);
