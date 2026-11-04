import { useForm, type SubmitHandler } from "react-hook-form";
import { registerUser } from "./api";
import "../App.css";

type RegisterFormData = {
  username: string;
  password: string;
};

function Register() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<RegisterFormData>();

  const onSubmit: SubmitHandler<RegisterFormData> = async (data) => {
    try {
      const res = await registerUser({
        username: data.username,
        password: data.password,
      });

      console.log("Registered:", res.data);
    } catch (err: any) {
      console.error(err.response?.data || err.message);
    }
  };

  return (
    <>
      <h2>Registration Form</h2>

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

export default Register;