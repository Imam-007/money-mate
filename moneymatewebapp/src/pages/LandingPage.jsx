import { Link } from "react-router-dom";

export default function LandingPage() {
  return (
    <div className="min-h-screen flex flex-col bg-white">
      {/* Navbar */}
      <nav className="flex justify-between items-center px-4 sm:px-6 md:px-10 py-4 md:py-6">
        {/* Logo */}
        <div className="flex items-center text-lg sm:text-xl font-semibold">
          Money Mate
        </div>

        {/* Right side buttons */}
        <div className="flex items-center space-x-2 sm:space-x-4">
          <Link
            to="/login"
            className="text-gray-800 font-medium text-sm sm:text-base"
          >
            Login
          </Link>
          <Link
            to="/signup"
            className="bg-purple-600 text-white px-4 sm:px-5 py-2 rounded-lg font-medium text-sm sm:text-base"
          >
            Get Started
          </Link>
        </div>
      </nav>

      {/* Hero Section */}
      <main className="flex flex-col items-center justify-center text-center flex-1 px-4">
        <h1 className="text-3xl sm:text-4xl md:text-5xl font-extrabold mb-4 sm:mb-6 leading-tight">
          Take Control of Your Finances
        </h1>
        <p className="text-gray-600 mb-6 sm:mb-8 max-w-lg sm:max-w-2xl text-base sm:text-lg">
          Your foundation for secure, intelligent financial management.
          Effortlessly track your income and expenses to achieve your financial
          goals.
        </p>

        {/* Buttons */}
        <div className="flex flex-col sm:flex-row gap-3 sm:space-x-4">
          <Link
            to="/signup"
            className="bg-purple-600 text-white px-6 py-3 rounded-md font-medium text-sm sm:text-base"
          >
            Start Tracking for Free
          </Link>
          <Link
            to="/about"
            className="bg-gray-200 px-6 py-3 rounded-md font-medium text-sm sm:text-base"
          >
            Learn More →
          </Link>
        </div>
      </main>
    </div>
  );
}
