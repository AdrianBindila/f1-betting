import {Col, Dropdown, ListGroup, Row, Tab, Tabs} from "react-bootstrap";

export const Stats = () => {
    return (<>View the statistics here.
        <Dropdown>
            <Dropdown.Toggle>
                Select a race
            </Dropdown.Toggle>
            <Dropdown.Menu>
                <Dropdown.Item href="">Bahrain</Dropdown.Item>
                <Dropdown.Item href="">China</Dropdown.Item>
                <Dropdown.Item href="">Azerbaijan</Dropdown.Item>
                <Dropdown.Item href="" disabled>Baku</Dropdown.Item>
            </Dropdown.Menu>
        </Dropdown>
        <h1>Bahrain GP</h1>
        <Row>
            <Col>
                <Tabs>
                    <Tab eventKey="fp1" title="FP1">
                        <ListGroup>
                            <ListGroup.Item>1. Albon 1:29:02</ListGroup.Item>
                            <ListGroup.Item>2. Bottas 1:30:01</ListGroup.Item>
                            <ListGroup.Item>3. Hamilton 1:31:22</ListGroup.Item>
                            <ListGroup.Item>4. Verstappen 1:32:15</ListGroup.Item>
                            <ListGroup.Item>5. Leclerc 1:33:17</ListGroup.Item>
                            <ListGroup.Item>6. Sainz 1:34:36</ListGroup.Item>
                            <ListGroup.Item>7. Jhou 1:40:12</ListGroup.Item>
                            <ListGroup.Item>8. Vettel 1:42:11</ListGroup.Item>
                        </ListGroup>
                    </Tab>
                    <Tab eventKey="fp2" title="FP2">Session is in progress...</Tab>
                    <Tab eventKey="fp3" title="FP3">Session is in progress...</Tab>
                </Tabs>
            </Col>
            <Col>
                <Tabs>
                    <Tab eventKey="Q1" title="Q1"></Tab>
                    <Tab eventKey="Q2" title="Q2"></Tab>
                    <Tab eventKey="Q3" title="Q3"></Tab>
                </Tabs>
            </Col>
            <Col>
                <Tabs>
                    <Tab eventKey="sprint" title="Sprint"></Tab>
                    <Tab eventKey="race" title="Race"></Tab>
                </Tabs>
            </Col>
        </Row>
    </>)
}