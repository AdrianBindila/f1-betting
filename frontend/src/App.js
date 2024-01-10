import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Login} from "./components/Login";
import {Landing} from "./components/Landing";
import {Stats} from "./components/Stats";
import {Bet} from "./components/Bet";
import {Admin} from "./components/Admin";
import {Home} from "./components/Home";
import {createContext} from "react";
import {UserProvider} from "./components/Context/UserProvider";
import {About} from "./components/About";

export const UserContext = createContext(null);

function App() {
    return (
        <UserProvider>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Landing/>}/>
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/home" element={<Home/>}/>
                    <Route path="/stats" element={<Stats/>}/>
                    <Route path="/bet" element={<Bet/>}/>
                    <Route path="/admin" element={<Admin/>}/>
                    <Route path="/about" element={<About/>}/>
                </Routes>
            </BrowserRouter>
        </UserProvider>
    );
}

export default App;
