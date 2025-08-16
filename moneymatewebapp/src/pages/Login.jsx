import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Input from "../components/Input";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  return (
    <div className="h-screen w-full relative flex items-center justify-center overflow-hidden">
      <div className="relative z-10 w-full max-w-lg px-6">
        <div className="bg-white bg-opacity-95 backdrop-blur-sm rounded-l-lg shadow-2xl p-8 max-h-[90vh] overflow-y-auto">
          <h3 className="text-2xl font-semibold text-black text-center mb-2">
            Welcome back!
          </h3>
          <p className="text-sm text-slate-700 text-center mb-8">
            Please enter your details.
          </p>
          <form className="space-y-4">
            <Input
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              label="Email Address"
              placeholder="xyz@gmail.com"
              type="text"
            />
            <Input
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              label="Password"
              placeholder="******"
              type="password"
            />
            {error && (
              <p className="text-red-800 text-sm text-center bg-red-50 p-2 rounded">
                {error}
              </p>
            )}
            <button
              className="w-full py-3 text-lg font-medium bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition"
              type="submit"
            >
              LOGIN
            </button>
            <p className="text-sm text-slate-800 text-center mt-6">
              Don’t have an account?{" "}
              <Link
                to="/signup"
                className="font-medium text-blue-600 underline hover:text-blue-800"
              >
                Signup
              </Link>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
