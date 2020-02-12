import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import app from './modules/App'
import login from './modules/Login'
import userList from './modules/UserList'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    app,
    login,
    userList
  },
  strict: true,
  plugins: [createPersistedState({
    key: 'AIRI',
    paths: ['app', 'userList'],
    storage: window.sessionStorage
  })]
})
