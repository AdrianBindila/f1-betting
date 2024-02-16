import {
    Button, Col, Dropdown, DropdownItem, Form, InputGroup, ListGroup, Modal, Row, Spinner, Tab, Table, Tabs
} from "react-bootstrap";
import {useState} from "react";
import {NewRaceModal} from "./NewRaceModal";
import {APIFetchModal} from "./APIFetchModal";
import {UserManagementModal} from "./UserManagementModal";

export const Admin = () => {
    const [showRaceModal, setShowRaceModal] = useState(false);
    const [showAPIModal, setShowAPIModal] = useState(false);
    const [showUserModal, setShowUserModal] = useState(false);

    return (<>
        <h1 style={{textAlign: 'center'}}>This is the admin panel</h1>
        <div>
            <Form>
                <Form.Check
                    type="switch"
                    id="email-switch"
                    label="Enable email notifications"
                />
                <Form.Check
                    type="switch"
                    id="betting-switch"
                    label="Enable random betting if not on time"
                />
            </Form>
        </div>
        <Row>
            <Col>
                <h1>Insert Race data</h1>
            </Col>
            <Col>
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        Select a race
                        {/*    TODO: change dropdown to carousel image modal with option to add a new race*/}
                    </Dropdown.Toggle>
                    <Button onClick={() => setShowRaceModal(true)}>Add a new race</Button>

                    <Dropdown.Menu>
                        <Dropdown.Item href="">Bahrain</Dropdown.Item>
                        <Dropdown.Item href="">Monza</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </Col>
            <Col>
                <Button onClick={() => setShowAPIModal(true)}>Fetch from API</Button>
                <Button onClick={() => setShowUserModal(true)}>User Management</Button>
            </Col>
        </Row>
        <Row>
            <Col>
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
        <NewRaceModal show={showRaceModal} setShow={setShowRaceModal}/>
        <APIFetchModal show={showAPIModal} setShow={setShowAPIModal}/>
        <UserManagementModal show={showUserModal} setShow={setShowUserModal}/>
    </>)
}