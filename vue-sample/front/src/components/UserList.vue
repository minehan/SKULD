<template>
  <div class="userList">
    <v-data-table
      :pagination.sync="pagination"
      :headers="headers"
      :items="items"
    >
      <template v-slot:items="props">
        <td>{{ props.item.name }}</td>
        <td>{{ props.item.phonetic }}</td>
        <td>{{ props.item.gender }}</td>
        <td>{{ props.item.email }}</td>
        <td>{{ props.item.age }}</td>
        <td>{{ props.item.birthplace }}</td>
        <td>{{ props.item.hireDate }}</td>
        <td>{{ props.item.rool }}</td>
        <td>{{ props.item.tel }}</td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  name: 'userList',
  computed: {
    ...mapState('userList', [
      'items',
      'headers'
    ]),
    pagination: {
      get () {
        return this.getPagination
      },
      set (pagination) {
        this.updatePageNation(pagination)
      }
    }
  },
  methods: {
    ...mapActions('userList', [
      'updatePageNation',
      // 'updatePageinationPage',
      'callGetUsersApi'
    ])
  },
  async created () {
    await this.callGetUsersApi()
  }
}
</script>
