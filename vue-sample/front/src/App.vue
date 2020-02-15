<template>
  <div id="app">
    <v-app>
      <Progress v-if="isFatch" />
      <Header v-if="isLogin" />
      <router-view/>
    </v-app>
  </div>
</template>

<script>
import Progress from '@/components/parts/Progress.vue'
import Header from '@/components/Header.vue'
import { mapState } from 'vuex'

export default {
  name: 'app',
  components: {
    Progress,
    Header
  },
  computed: {
    ...mapState('app', [
      'isFatch',
      'isLogin'
    ])
  }
}
</script>

<style>
</style>
