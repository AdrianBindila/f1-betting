import {Button, Col, Dropdown, DropdownItem, InputGroup, ListGroup, Row, Tab, Table, Tabs} from "react-bootstrap";

export const Admin = () => {
    return (<>
        <h1 style={{textAlign: 'center'}}>This is the admin panel</h1>
        <div>
            <InputGroup>
                <InputGroup.Checkbox/>
                <InputGroup.Text>Enable email notifications</InputGroup.Text>
            </InputGroup>
        </div>
        <Row>
            <Col>
                <h1>Insert Race data</h1>
            </Col>
            <Col>
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        Select a race
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="">Bahrain</Dropdown.Item>
                        <Dropdown.Item href="">Monza</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </Col>
            <Col>
                <Button>Fetch from API</Button>
                <Button>Apply</Button>
                <Button>Reset</Button>
            </Col>
        </Row>
        <Row>
            <Col>
                <InputGroup>
                    <InputGroup.Checkbox/>
                    <InputGroup.Text>Enable random betting if not on time</InputGroup.Text>
                </InputGroup>
                Betting cutoff: <input type="time"/>
                <Row>
                    <Col>
                        <Tabs>
                            <Tab eventKey="fp1" title="FP1">
                                <Table>
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Driver Name</th>
                                        <th>Time</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Valtteri Bottas</td>
                                            <td>1:24.418</td>
                                            <td>
                                                <Button>Save</Button>
                                                <Button>Clear</Button>
                                                <Button>Edit</Button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </Table>
                            </Tab>
                            <Tab eventKey="fp2" title="FP2">Session is in progress...</Tab>
                            <Tab eventKey="fp3" title="FP3">Session is in progress...</Tab>
                            <Tab eventKey="Q1" title="Q1"></Tab>
                            <Tab eventKey="Q2" title="Q2"></Tab>
                            <Tab eventKey="Q3" title="Q3"></Tab>
                            <Tab eventKey="sprint" title="Sprint"></Tab>
                            <Tab eventKey="race" title="Race"></Tab>
                        </Tabs>
                    </Col>
                </Row>
            </Col>
        </Row>
    </>)
}