import axios from "axios";

export const useAxios = () => {
  const axiosConfig = {
    baseURL: import.meta.env.VITE_API_BASE_URL,
    timeout: 30000, // 30s
  };

  return {
    api: axios.create(axiosConfig),
  };
};
