import { useAxios } from "@/plugins/axios";
import { AxiosError, AxiosResponse } from "axios";
import { Ref, computed, unref } from "vue";
import { useMutation, useQuery } from "vue-query";

export type Memo = {
  id: number;
  content: string;
  isDone: boolean;
};

export const useMemoList = () => {
  const { api } = useAxios();

  const { isLoading, isError, isFetching, data, error, refetch } = useQuery({
    queryKey: ["/api/memo"],
    queryFn: () => api.get("/api/memo"),
  });

  const resultData = computed<Memo[]>(() => {
    return data.value?.data;
  });

  return {
    isLoading,
    isError,
    isFetching,
    data,
    resultData,
    error,
    refetch,
  };
};

export const useNewMemo = () => {
  const { api } = useAxios();

  const { mutate, data, isLoading, isError } = useMutation<
    AxiosResponse<ResultResponse>,
    AxiosError
  >(() => {
    return api.post("/api/memo");
  });

  const resultData = computed<ResultResponse>(() => {
    return data.value?.data;
  });

  return {
    mutate,
    resultData,
    isLoading,
    isError,
  };
};

export type ResultResponse = {
  id: string;
  isSuccess: boolean;
};

export const useUpdateMemo = (memo: Ref<Memo | undefined>) => {
  const { api } = useAxios();

  const { mutate, data, isLoading, isError } = useMutation<
    AxiosResponse<ResultResponse>,
    AxiosError
  >(() => {
    return api.put(`/api/memo/${unref(memo)?.id}`, { ...memo.value });
  });

  const resultData = computed<ResultResponse>(() => {
    return data.value?.data;
  });

  return {
    mutate,
    resultData,
    isLoading,
    isError,
  };
};
