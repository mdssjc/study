import { Identity } from "./monads/identity";
import { List } from "./monads/list";

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
