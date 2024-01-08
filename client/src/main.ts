import { createApp } from "vue";
import App from "@/App.vue";
import { VueQueryPlugin } from "vue-query";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

export const apiUrlTest = process.env.API_URL_TEST;

const app = createApp(App);
app.use(VueQueryPlugin);
app.use(ElementPlus);
app.mount("#app");
