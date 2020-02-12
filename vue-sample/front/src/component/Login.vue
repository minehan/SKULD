<template>
  <div class="login-content">
    <form class="login-form">
      <v-text-field
        label="Name">
      </v-text-field>
      <v-text-field
        label="password"
        type="password"
        >
      </v-text-field>
      <v-btn
        class="white--text"
        block=ture
        @click="submit"
        color="#7fbfff">
          ログイン
      </v-btn>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  props: {}
}
</script>
<style scoped>
.login-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);
  width: 50%;
  min-width: 600px;
  height: 400px;
  border: solid 1px #c7c7c7;
}

.login-form {
  margin-top: 60px;
  padding: 50px 250px;
}
</style>
