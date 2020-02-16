<script>
  export let goal;

  $: doWarning = goal.includes("!");
</script>

<style>
  .warning {
    color: red;
  }
</style>

<h1 class:warning={doWarning}>{goal}</h1>
