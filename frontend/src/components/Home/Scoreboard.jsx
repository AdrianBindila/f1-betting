import {ListGroup, Modal, Spinner} from "react-bootstrap";
import "../../styles/Home.css"
import {useEffect, useState} from "react";
import axios from "axios";

export const Scoreboard = () => {
    const [userList, setUserList] = useState([]);
    const [selectedUser, setSelectedUser] = useState({username: ""});
    const [selectedUserDetails, setSelectedUserDetails] = useState();
    const [show, setShow] = useState(false);

    async function getUsers() {
        await axios.get("/user/all")
            .then((res) => {
                console.log(res.data);
                setUserList(res.data);
            })
            .catch(err => console.log(err));
    }

    async function getSelectedUserDetails(user) {
        await axios.get("/user/" + user.username)
            .then((res) => {
                console.log(res.data);
                setSelectedUserDetails(res.data);
            })
            .catch(err => console.log(err));
    }

    useEffect(() => {
        getUsers();
    }, []);

    return (
        <>
            <div className="betting-list">
                <h2>Betting scoreboard</h2>
                <ListGroup>
                    {/*on click go to the user profile info or
                            show a modal with some user stats*/}
                    {userList?.map(
                        user => {
                            return <ListGroup.Item key={user.id} action onClick={() => {
                                setSelectedUser(user);
                                setShow(true)
                            }}>{user.username + " (" + user.score + ")"}</ListGroup.Item>
                        })
                    }
                </ListGroup>
            </div>
            {/*Modal that shows stats about the selected user's betting history*/}
            <Modal show={show}
                   onHide={() => setShow(false)}
                   onShow={() => getSelectedUserDetails(selectedUser)}
            >
                <Modal.Header closeButton>
                    {selectedUser.username}'s score stats
                </Modal.Header>
                <Modal.Body>
                    {selectedUserDetails ?
                        //     show the betting list of a user
                        <div>{selectedUserDetails.bets}</div>
                        :
                        <Spinner/>}
                </Modal.Body>
            </Modal>
        </>
    )
}