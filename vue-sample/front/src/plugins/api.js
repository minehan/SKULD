import axios from 'axios'
import { URL_BASE } from '../const/api'

export function getUsers () {
  return axios.get(`${URL_BASE}/users`)
    .then(res => res.data)
    .catch(e => console.log(e))
}

export function postLogin (param) {
  return axios.post(`${URL_BASE}/login`, param)
    .then(res => res.data)
    .catch(e => console.log(e))
}
