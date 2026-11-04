import { useForm, type SubmitHandler } from "react-hook-form";
import { loginUser } from "./api";
import "../App.css";

type LoginFormData = {
  username: string;
  password: string;
};

function Login() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginFormData>();

  const onSubmit: SubmitHandler<LoginFormData> = async (data) => {
    try {
      const res = await loginUser({
        username: data.username,
        password: data.password,
      });

      // Login returns token
      const token = res.data.token || res.data.accessToken;
      if (token) localStorage.setItem("token", token);

      console.log("Login success:", res.data);
    } catch (err: any) {
      console.error(err.response?.data || err.message);
    }
  };

  return (
    <>
      <h2>Login Form</h2>

      <form className="App" onSubmit={handleSubmit(onSubmit)}>
        <input
          type="text"
          {...register("username", { required: true })}
          placeholder="Username"
        />
        {errors.username && (
          <span style={{ color: "red" }}>*Username* is mandatory</span>
        )}

        <input
          type="password"
          {...register("password", { required: true })}
          placeholder="Password"
        />
        {errors.password && (
          <span style={{ color: "red" }}>*Password* is mandatory</span>
        )}

        <input type="submit" style={{ backgroundColor: "#a1eafb" }} />
      </form>
    </>
  );
}

export default Login;