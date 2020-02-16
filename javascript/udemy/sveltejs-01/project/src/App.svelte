<script>
  let name = 'Max'
  let age = 30

  $: upperCaseName = name.toUpperCase()

  $: console.log(name)

  $: if (name === 'Maximilian') {
    console.log('It runs!')
    age = 31
  }

  function incrementAge() {
    age++
  }

  function changeName() {
    name = 'Maximilian'
  }

  function nameInput(event) {
    const enteredValue = event.target.value
    name = enteredValue
  }
</script>

<style>
  h1 {
    color: purple;
  }
</style>

<h1>Hello {upperCaseName}!, my age is {age}!</h1>
<button on:click={incrementAge}>Change Age</button>
<!-- <button on:click={changeName}>Change Name</button> -->
<input type="text" value={name} on:input={nameInput} />
