<template>
  <div class="about">
    <h1>This is an about page</h1>
    <p>{{ this.$store.state.num }}</p>
    <p>{{ this.$store.getters.newnum }}</p>
  </div>
</template>
