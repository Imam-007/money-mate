import { useEffect, useState } from "react";
import Dashboard from "../components/Dashboard";
import { useUser } from "../hooks/useUser";
import axiosConfig from "../util/AxiosConfig";
import { API_ENDPOINTS } from "../util/apiEnpoints";
import toast from "react-hot-toast";
import IncomeList from "../components/IncomeList";

const Income = () => {
  useUser();

  const [incomeData, setIncomeData] = useState([]);
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(false);

  const [openAddIncomeModal, setOpenAddIncomeModal] = useState(false);
  const [openDeleteAlert, setOpenDeleteAlert] = useState({
    show: false,
    data: null,
  });

  const fetchIncomeDetails = async () => {
    if (loading) {
      return;
    }
    setLoading(true);

    try {
      const response = await axiosConfig.get(API_ENDPOINTS.GET_ALL_INCOMES);
      if (response.status === 200) {
        setIncomeData(response.data);
      }
    } catch (error) {
      console.error("Failed to fetch income detailes", error);
      toast.error(
        error.response?.data?.message || "failed while feacting income"
      );
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchIncomeDetails();
  }, []);
  return (
    <Dashboard activeMenu="Income">
      <div className="my-5 mx-auto">
        <div className="grid grid-cols-1 gap-6">
          <div>{/*overview for incomewith line car */}</div>
          <IncomeList
            transactions={incomeData}
            onDelete={(id) => console.log("deleting the income", id)}
          />
        </div>
      </div>
    </Dashboard>
  );
};

export default Income;
