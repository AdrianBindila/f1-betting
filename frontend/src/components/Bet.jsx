import {Button, Card, Col, ListGroup, Row} from "react-bootstrap";
import "../styles/Bet.css"

export const Bet = () => {
    return (
        <>Here's where you place a bet!
            <Row>
                <Col>
                    <h2>Your previous P10 bets</h2>
                    <ListGroup>
                        <ListGroup.Item>1.(Bahrain) Albon +20</ListGroup.Item>
                    </ListGroup>
                </Col>
                <Col>
                    <h2>Your previous DNF bets</h2>
                    <ListGroup>
                        <ListGroup.Item>1.(Bahrain) Jhou +0</ListGroup.Item>
                        <ListGroup.Item>1.(Monza) Leclerc +10</ListGroup.Item>
                    </ListGroup>
                </Col>
                <Col>
                    <h2>Betting order</h2>
                    <ListGroup>
                        <ListGroup.Item>Denis ✅</ListGroup.Item>
                        <ListGroup.Item>Cata 🕙</ListGroup.Item>
                        <ListGroup.Item>Cioba ❌</ListGroup.Item>
                        <ListGroup.Item>Adi ❌</ListGroup.Item>
                    </ListGroup>
                    <h3>Betting ends at: 16:30</h3>
                </Col>
            </Row>
            <Row>
                <Col>


                    <h2>Select a driver to bet on:</h2>
                    <ListGroup className="list-class">
                        <ListGroup.Item action>Leclerc</ListGroup.Item>
                        <ListGroup.Item action>Bottas</ListGroup.Item>
                        <ListGroup.Item action>Hamilton</ListGroup.Item>
                        <ListGroup.Item action>Jhou</ListGroup.Item>
                        <ListGroup.Item action>Giovinnazzi</ListGroup.Item>
                    </ListGroup>
                </Col>
                <Col>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="pictures/valtteri-bottas.jpg"/>
                        <Card.Body>
                            <Card.Title>Valterri Bottas</Card.Title>
                            <Card.Text>
                                <h5># of P10s: 7</h5>
                                <h5># of DNFs: 4</h5>
                            </Card.Text>
                            <Card.Footer>
                                <Button variant="primary">Bet P10</Button>
                                <Button variant="primary">Bet DNF</Button>
                            </Card.Footer>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </>
    )
}