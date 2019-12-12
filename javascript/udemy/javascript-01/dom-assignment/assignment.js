const message = 'Assignment - Solved!';

// STEP 1
const task1 = document.getElementById('task-1');
const task2 = document.querySelector('#task-1');

task1.style.backgroundColor = 'black';
task2.style.color = 'white';

// STEP 2
const title = document.querySelector('title');
title.textContent = message;

document.title = message;

// STEP 3
const h1 = document.querySelector('h1');
h1.textContent = message;
