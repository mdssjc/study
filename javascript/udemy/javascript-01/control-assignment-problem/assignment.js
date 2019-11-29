const randomNumber = Math.random(); // produces random number between 0 (including) and 1 (excluding)

// Step 1
if (randomNumber > 0.7) {
  alert('You hit!');
}

// Step 2
const numbers = [1, 1, 2, 3, 5, 8, 13, 21];

for (let i = 0; i < numbers.length; i++) {
  console.log(numbers[i]);
}

for (const number of numbers) {
  console.log(number);
}

let i = 0;
while (i < numbers.length) {
  console.log(numbers[i]);
  i++;
}

// Step 3
for (let i = numbers.length - 1; i >= 0; i--) {
  console.log(numbers[i]);
}

// Step 4
const randomNumber2 = Math.random();

if (
  (randomNumber > 0.7 && randomNumber2 > 0.7) ||
  randomNumber2 <= 0.2 ||
  randomNumber <= 0.2
) {
  alert('You hit!');
}
