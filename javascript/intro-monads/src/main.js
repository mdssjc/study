import { Identity } from "./monads/identity";

// Identity
// emit: join, value
// chain: flatMap, bind
// map: fmap
const one = Identity.of(1);
const two = one.map(a => a + 1);

console.log(one.emit());
console.log(one.chain(a => a + 1));
console.log(one.map(a => a + 1));
console.log(two.inspect());
