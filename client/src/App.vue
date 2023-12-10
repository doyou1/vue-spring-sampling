<script setup>
import axios from "axios";
import { useQuery } from "vue-query";

const { isLoading, isError, data: result, error, isFetching } = useQuery(
    ["/api/messages/hello"],
    async () => {
      return axios.get("http://localhost:5000/api/messages/hello");
    },
  );

</script>

<template>
  <div>
    Hello World {{ data }}
  </div>
</template>

<style scoped></style>
