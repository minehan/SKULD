const state = {
  userId: '',
  isLogin: false,
  isFatch: false
}

// getXXで統一
const getters = {}

// actionsを必ず経由してcommitするようにする
const actions = {
  logout ({ commit }) {
    commit('setIsLogin', false)
  }
}

// setXXで統一
const mutations = {
  setUserId (state, payload) {
    state.userId = payload
  },
  setIsFatch (state, payload) {
    state.isFatch = payload
  },
  setIsLogin (state, payload) {
    state.isLogin = payload
  }
}

export default { namespaced: true, state, getters, actions, mutations }
