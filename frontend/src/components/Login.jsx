import "../styles/Login.css"
import {Button, FloatingLabel, Form, FormControl} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {useContext, useState} from "react";
import axios from "axios";
import {UserContext} from "../App";

export const Login = () => {
    const {user, setUser} = useContext(UserContext);

    const [login, setLogin] = useState({
        username: "",
        password: "",
    });
    const navigator = useNavigate();

    async function sendLogin(login) {
        await axios
            .post("/auth/login", login)
            .then((res) => {
                console.log("Logged in user " + res.data.username);
                setUser(res.data);
                navigator("/home");
            })
            .catch((err) => console.log(err));
    }

    function handleChange(event) {
        const {name, value} = event.target;
        setLogin((prev) => {
            return {
                ...prev,
                [name]: value,
            };
        });
    }

    function handleSubmit(event) {
        if (login.username && login.password) {
            sendLogin(login);
            setLogin({
                username: "",
                password: "",
            });
        } else {
            alert("Both the username and password fields must be completed!")
        }
        event.preventDefault();
    }

    return (
        <div className="box">
            <h2>Login</h2>
            <Form onSubmit={handleSubmit}>
                <FloatingLabel label="Username">
                    <FormControl
                        type="text"
                        placeholder="Username"
                        name="username"
                        value={login.username}
                        onChange={handleChange}
                    />
                </FloatingLabel>
                <FloatingLabel label="Password">
                    <FormControl
                        type="password"
                        placeholder="Password"
                        name="password"
                        value={login.password}
                        onChange={handleChange}
                    />
                </FloatingLabel>
                <Button className="w-100 btn btn-lg btn-warning btn-user" type="submit">
                    Sign in
                </Button>
            </Form>
        </div>
    )
}