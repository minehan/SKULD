import { postLogin } from '../../plugins/api'
import { STATUS } from '../../const/api'
import getErrorMessage from '../../const/errorMessage'
// import userList from './UserList'

const state = {
  name: '',
  password: '',
  errorMessage: ''
}

// getXXで統一 -> stateの値を加工して返すのに使用するらしい
const getters = {}

// actionsを必ず経由してcommitするようにする
const actions = {
  updateName ({ commit }, payload) {
    commit('setName', payload)
  },
  updatePassword ({ commit }, payload) {
    commit('setPassword', payload)
  },
  async callLoginApi ({ commit, state }) {
    commit('app/setIsFatch', true, { root: true })
    const { status, result, message } = await postLogin({ login_name: state.name, password: state.password })
    if (status === STATUS.ERROR) {
      commit('setEroorMessage', getErrorMessage(message))
    } else {
      commit('setEroorMessage', '')
      commit('app/setUserId', result.id, { root: true })
      commit('app/setIsLogin', true, { root: true })
    }
    commit('setName', '')
    commit('setPassword', '')
    commit('app/setIsFatch', false, { root: true })
  }
}

// setXXで統一
const mutations = {
  setName (state, payload) {
    state.name = payload
  },
  setPassword (state, payload) {
    state.password = payload
  },
  setEroorMessage (state, payload) {
    state.errorMessage = payload
  }
}

export default { namespaced: true, state, getters, actions, mutations }
