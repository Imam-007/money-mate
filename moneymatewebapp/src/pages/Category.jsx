import { Plus } from "lucide-react";
import Dashboard from "../components/Dashboard";
import { useUser } from "../hooks/useUser";
import CategoryList from "../components/CategoryList";
import { useEffect, useState } from "react";
import axiosConfig from "../util/AxiosConfig";
import { API_ENDPOINTS } from "../util/apiEnpoints";
import toast from "react-hot-toast";

const Category = () => {
  useUser();

  const [loading, setLoding] = useState(false);
  const [categoryData, setCategoryData] = useState([]);
  const [openAddCategorymodel, setOpenAddCategoryModel] = useState(false);
  const [openEditCategoryModel, setOpenEditCategoryModel] = useState(false);
  const [selectCategory, setSelectCategory] = useState(null);

  const fetchCategoryDetails = async () => {
    if (loading) {
      return;
    }
    setLoding(true);

    try {
      const response = await axiosConfig.get(API_ENDPOINTS.GET_ALL_CATEGORIES);
      if (response.status === 200) {
        console.log("categories", response.data);
        setCategoryData(response.data);
      }
    } catch (error) {
      console.log("Somethings went wrong. Please try again");
      toast.error(error.message);
    } finally {
      setLoding(false);
    }
  };

  useEffect(() => {
    fetchCategoryDetails();
  }, []);

  return (
    <Dashboard activeMenu="Category">
      <div className="my-5 mx-auto">
        <div className="flex justify-between items-center mb-5">
          <h2 className="text-2xl font-semibold">All Categories</h2>
          <button className=" cursor-pointer flex items-center gap-1 bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded-md shadow">
            <Plus size={15} />
            Add Category
          </button>
        </div>
        <CategoryList categories={categoryData} />
      </div>
    </Dashboard>
  );
};

export default Category;
