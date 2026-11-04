import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080/api/v1",
  headers: {
    "Content-Type": "application/json",
  },
});

api.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export type RegisterPayload = {
  username: string;
  password: string;
};

export type LoginPayload = {
  username: string;
  password: string;
};

export const registerUser = (payload: RegisterPayload) =>
  api.post("/user/register", payload);

export const loginUser = (payload: LoginPayload) =>
  api.post("/user/login", payload);