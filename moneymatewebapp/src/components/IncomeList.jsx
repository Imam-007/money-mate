import { Download, Mail } from "lucide-react";
import TransactionsInfoCard from "./TransactionsInfoCard";
import moment from "moment";

const IncomeList = ({ transactions, onDelete }) => {
  return (
    <div className="rounded-2xl shadow-md bg-white p-4">
      <div className="flex items-center justify-between">
        <h5 className="text-lg font-semibold">Income Source</h5>
        <div className="flex items-center gap-2">
          <button className="px-3 py-1 rounded-xl bg-blue-500 text-white flex items-center gap-1 hover:bg-blue-600">
            <Mail size={15} /> Email
          </button>
          <button className="px-3 py-1 rounded-xl bg-green-500 text-white flex items-center gap-1 hover:bg-green-600">
            <Download size={15} /> Download
          </button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2">
        {transactions?.map((income) => (
          <TransactionsInfoCard
            key={income.id}
            title={income.name}
            icon={income.icon}
            date={moment(income.date).format("Do MMM YYYY")}
            amount={income.amount}
            type="income"
            onDelete={() => onDelete(income.id)}
          />
        ))}
      </div>
    </div>
  );
};

export default IncomeList;
