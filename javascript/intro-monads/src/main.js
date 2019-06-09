import { Identity } from "./monads/identity";

// Identity
const one = Identity(1);

console.log(one.emit());
