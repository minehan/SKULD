<template>
<div class="login">
  <div class="login-content">
    <p v-if="errorMessage" class="error-msg">{{errorMessage}}</p>
    <form class="login-form">
      <v-text-field
        label="Name"
        :value="name"
        @input="updateName"
      >
      </v-text-field>
      <v-text-field
        label="password"
        type="password"
        :value="password"
        @input="updatePassword"
        >
      </v-text-field>
      <v-btn
        class="white--text"
        color="#7fbfff"
        @click="callLoginApi"
      >
        ログイン
      </v-btn>
    </form>
  </div>
</div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  name: 'login',
  computed: {
    ...mapState('login', [
      'name',
      'password',
      'errorMessage'
    ]),
    ...mapState('app', [
      'isLogin'
    ])
  },
  watch: {
    isLogin (val) {
      // login成功でトップページへ
      if (val) this.$router.push('/')
    }
  },
  methods: {
    ...mapActions('login', [
      'updateName',
      'updatePassword',
      'callLoginApi'
    ])
  }
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

.login-content button {
  width: 100%;
}

.error-msg {
  color: #ff0000;
}

.login-form {
  margin-top: 60px;
  padding: 50px 250px;
}
</style>
