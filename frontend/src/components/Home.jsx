import '../styles/Home.css'
import {Button, Col, Row} from "react-bootstrap";
import {useNavigate} from "react-router-dom";

export const Home = () => {
    const navigator = useNavigate();
    function login() {
        navigator("/login")
    }

    return (
        <div className="home-box">
            <Row>
                <Col sm={4}>
                    <img className="home-image" src="/pictures/f1-car.png" alt="F1 cars"/>
                </Col>
                <Col>
                    <h2>Welcome to the future of F1 betting.</h2>
                    <h6>Who will become the next P10 winner or DNF King?</h6>
                    <hr/>
                    <Button type="button" size="lg" onClick={login}>LOG IN</Button>
                </Col>
            </Row>
        </div>
    )
}