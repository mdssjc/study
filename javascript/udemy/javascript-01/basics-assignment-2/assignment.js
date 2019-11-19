const task3Element = document.getElementById('task-3');

// Step 1
function show() {
  alert('Hello');
}

function showName(name) {
  alert(name);
}

// Step 2
show();
showName('John');

// Step 3
task3Element.addEventListener('click', show);

// Step 4
function concat(a, b, c) {
  return `${a} ${b} ${c}`;
}

// Step 5
alert(concat('Hello', 'World', '!'));
