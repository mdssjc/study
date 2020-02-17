<script>
  let password = "";
  let passwords = [];
  let message = "";
  let isValid = false;

  $: if (password.trim().length < 5) {
    isValid = false;
    message = "Too short";
  } else if (password.trim().length > 10) {
    isValid = false;
    message = "Too long";
  } else {
    isValid = true;
  }

  function savePassword() {
    if (isValid) {
      passwords = [...passwords, password];
    }
  }

  function removePassword(index) {
    passwords = passwords.filter((pw, idx) => idx !== index);
  }
</script>

<h1>Assignment</h1>

<p>Solve these tasks.</p>

<ol>
  <li>Add a password input field and save the user input in a variable.</li>
  <li>
    Output "Too short" if the password is shorter than 5 characters and "Too
    long" if it's longer than 10.
  </li>
  <li>
    Output the password in a paragraph tag if it's between these boundaries.
  </li>
  <li>Add a button and let the user add the passwords to an array.</li>
  <li>Output the array values (= passwords) in a unordered list (ul tag).</li>
  <li>Bonus: If a password is clicked, remove it from the list.</li>
</ol>

<input type="password" bind:value={password} />
<button on:click={savePassword}>Save</button>

{#if isValid}
  <p>Password: {password}</p>
{:else}
  <p>Password: {message}</p>
{/if}

<ul>
  {#each passwords as password, index}
    <li on:click={removePassword.bind(this, index)}>{password}</li>
  {/each}
</ul>
