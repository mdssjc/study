<script>
  let name = "Max";
  let age = 30;

  function incrementAge() {
    age++;
  }
</script>

<style>
  h1 {
    color: purple;
  }
</style>

<h1>Hello {name}!, my age is {age}!</h1>
<button on:click={incrementAge}>Change Age</button>
