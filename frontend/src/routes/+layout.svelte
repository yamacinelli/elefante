<script>
  import 'carbon-components-svelte/css/all.css';

  let { children } = $props();
</script>

<div class="bx--body">
  {@render children()}
</div>
