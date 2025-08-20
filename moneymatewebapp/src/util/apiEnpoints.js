// export const BASE_URL = "https://money-mate-demo.onrender.com/api/v1";
export const BASE_URL = "http://localhost:8080/api/v1";
const CLOUDINARY_CLOUD_NAME = "dcizq5kte";

export const API_ENDPOINTS = {
  LOGIN: "/login",
  REGISTER: "/register",
  GET_USER_INFO: "/profile",
  GET_ALL_CATEGORIES: "/categories",
  ADD_CATEGORY: "/categories",
  UPDATE_CATEGORY: (categoryId) => `categories/${categoryId}`,
  GET_ALL_INCOMES: "/incomes",
  UPLOAD_IMAGE: `https://api.cloudinary.com/v1_1/${CLOUDINARY_CLOUD_NAME}/image/upload`,
};
