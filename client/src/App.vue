<template>
  <h2>result</h2>
  <ul>
    <li v-for="memo in memoList" :key="memo.id">
      <el-input
        :model-value="memo.content"
        placeholder="please write todo"
        @update:model-value="update($event as string, memo.id, 'content')"
      />
      <el-checkbox
        :model-value="memo.isDone"
        label="is done"
        size="large"
        @update:model-value="update($event as boolean, memo.id, 'isDone')"
      />
    </li>
  </ul>
  <el-button type="primary" :icon="DocumentAdd" @click="add" />
</template>

<script setup lang="ts">
import { Memo, useMemoList, useUpdateMemo, useNewMemo } from "@/composables/use-memo";
import { ElInput, ElCheckbox, ElButton } from "element-plus";
import { ref, watch } from "vue";
import invariant from "tiny-invariant";
import { DocumentAdd } from '@element-plus/icons-vue'

const { resultData: memoList, refetch: refetchMemoList } = useMemoList();
const updateItem = ref<Memo>();
const { resultData: updateResponse, mutate: updateMemo } = useUpdateMemo(updateItem);
const { resultData: addResponse, mutate: addMemo } = useNewMemo();

const update = (
  value: boolean | string,
  id: number,
  type: "isDone" | "content",
) => {
  const filtered = memoList.value.filter((v) => v.id === id);
  if (filtered.length === 1) {
    const newItem = { ...filtered[0] };

    switch (type) {
      case "isDone": {
        invariant(typeof value === "boolean");
        newItem[type] = value;
        break;
      }
      case "content": {
        invariant(typeof value === "string");
        newItem[type] = value;
      }
    }

    updateItem.value = newItem;
    updateMemo();
    watch(updateResponse, () => {
      if (updateResponse.value?.isSuccess) {
        refetchMemoList.value();
      }
    });
  }
};

const add = () => {
  addMemo();
  watch(addResponse, () => {
    if (addResponse.value?.isSuccess) {
      refetchMemoList.value();
    }
  });
}
</script>

<style scoped lang="scss">
.el-input {
  width: auto;
}
</style>
