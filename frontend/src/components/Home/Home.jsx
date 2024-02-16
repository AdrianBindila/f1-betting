import {useContext} from "react";
import {UserContext} from "../../App";
import {Button, Col, Dropdown, ListGroup, Row} from "react-bootstrap";
import "../../styles/Home.css"
import {useNavigate} from "react-router-dom";
import {Scoreboard} from "./Scoreboard";
import {Statboard} from "./Statboard";

export const Home = () => {
    const {user, setUser} = useContext(UserContext);
    const navigator = useNavigate();
    return (
        <>
            <Row>
                <Col>
                    <div>
                        <Button onClick={()=>navigator('/stats')}>Races/Stats</Button>
                        <Button onClick={()=>navigator('/bet')}>Betting</Button>
                        <Button onClick={()=>navigator('/about')}>About</Button>
                    </div>
                </Col>
                <Col>
                    <div className="user-dropdown">
                        <Dropdown>
                            <Dropdown.Toggle variant="success" id="dropdown-basic">
                                Welcome user {user.username}!
                            </Dropdown.Toggle>

                            <Dropdown.Menu>
                                <Dropdown.Item href="">Logout</Dropdown.Item>
                                <Dropdown.Item href="">Settings</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </div>
                </Col>
            </Row>
            <Row>
                <Col>
                    <Scoreboard/>
                </Col>
                <Col>
                    <Statboard/>
                </Col>
            </Row>
        </>
    )
}