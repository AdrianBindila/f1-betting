import {useContext} from "react";
import {UserContext} from "../App";
import {Button, Col, Dropdown, ListGroup, Row} from "react-bootstrap";
import "../styles/Home.css"
import {useNavigate} from "react-router-dom";

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
                    <div className="betting-list">
                        <h2>Betting scoreboard</h2>
                        <ListGroup>
                            {/*on click go to the user profile info or
                            show a modal with some user stats*/}
                            <ListGroup.Item action>Denis 176 (+10)</ListGroup.Item>
                            <ListGroup.Item action>Cioba 156 (+15)</ListGroup.Item>
                            <ListGroup.Item action>Cătă 132 (+5)</ListGroup.Item>
                            <ListGroup.Item action>Vlad 120 (+20)</ListGroup.Item>
                            <ListGroup.Item action>Adi 116 (+12)</ListGroup.Item>
                        </ListGroup>
                    </div>
                </Col>
                <Col>
                    <div className="betting-stats">
                        <h2>Next race:</h2>
                        <h3>Bahrain GP 2023 (image)</h3>
                        <h2>Previous P10 winner:</h2>
                        <h3>Lance Stroll (Denis) (image)</h3>
                        <h2>Previous DNF winner:</h2>
                        <h3>Alex Albon (Adi) (image)</h3>
                    </div>
                </Col>
            </Row>
        </>
    )
}