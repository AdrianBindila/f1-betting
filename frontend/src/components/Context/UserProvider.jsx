import {useEffect, useState} from "react";
import {UserContext} from "../../App";

export function UserProvider({children}) {
    const [user, setUser] = useState(JSON.parse(localStorage.getItem('user')) || {
        username: "",
        email: "",
        firstName: "",
        lastName: ""
    });
    useEffect(() => {
        localStorage.setItem('user', JSON.stringify(user));
    }, [user]);
    return (
        <UserContext.Provider value={{user, setUser}}>
            {children}
        </UserContext.Provider>
    )
}