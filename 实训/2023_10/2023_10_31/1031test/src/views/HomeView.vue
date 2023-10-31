<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <p>{{ $store.state.num }}</p>
    <p>{{ $store.getters.newnum }}</p>

    <button @click="change">change</button>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  data(){
    return{
      
    }
  },

  methods: {
    change(){
      this.$store.dispatch('addMethod', 6);
    }
  },

  components: {
    HelloWorld
  }
}
</script>
