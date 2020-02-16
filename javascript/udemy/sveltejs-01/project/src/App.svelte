<script>
  let name = "Max";
  let age = 30;

  $: upperCaseName = name.toUpperCase();

  function incrementAge() {
    age++;
  }

  function changeName() {
    name = "Maximilian";
  }
</script>

<style>
  h1 {
    color: purple;
  }
</style>

<h1>Hello {upperCaseName}!, my age is {age}!</h1>
<button on:click={incrementAge}>Change Age</button>
<button on:click={changeName}>Change Name</button>
