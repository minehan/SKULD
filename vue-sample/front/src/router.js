import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login.vue'
import UserCreate from '@/components/UserCreate.vue'
import UserDetail from '@/components/UserDetail.vue'
import UserList from '@/components/UserList.vue'
import store from '@/store/index'

Vue.use(Router)
const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    { path: '/', name: 'userList', component: UserList, meta: { auth: true } },
    { path: '/login', name: 'login', component: Login },
    { path: '/user-create', name: 'userCreate', component: UserCreate, meta: { auth: true } },
    { path: '/user-detail/:userID', name: 'userDetail', component: UserDetail, meta: { auth: true } }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.auth) && !store.state.app.isLogin) {
    next({ path: '/login' })
  } else if (to.path.indexOf('login') > -1) {
    store.dispatch('app/logout')
    next()
  } else {
    next()
  }
})

export default router
