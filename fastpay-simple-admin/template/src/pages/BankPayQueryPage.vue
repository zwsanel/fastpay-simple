<template>
  <page>
    <div class="q-pa-md">
      <q-card flat bordered>
        <q-card-section>
          <q-list dense class="row">
            <q-item>
              <q-item-section>流水号</q-item-section>
              <q-item-section side>
                <q-input v-model="form.requestNo" outlined dense></q-input>
              </q-item-section>
            </q-item>
            <q-item>
              <q-item-section>
                <q-btn label="查询" icon="search" @click="bankPayInList"></q-btn>
              </q-item-section>
            </q-item>
          </q-list>
        </q-card-section>
        <q-separator></q-separator>
        <q-table separator="cell" :columns="columns" :rows="rows"></q-table>
      </q-card>
    </div>
  </page>
</template>

<script setup lang="ts">
import { ref } from "vue";
import axios from "axios";

const form = ref({
  requestNo: ''
})

const columns = ref([])
const rows = ref([])

const bankPayInList = function () {
  axios.get('/admin/bankPayInList', { params: form.value }).then(value => {
    rows.value = value.data
  })
}

</script>

<style scoped>

</style>
