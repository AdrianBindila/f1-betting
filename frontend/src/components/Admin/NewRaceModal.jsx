import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import {useState} from "react";
import PropTypes from "prop-types";

export function NewRaceModal({show, setShow}) {
    const [sprint, setSprint] = useState(false);

    function toggleSprintRace() {
        setSprint(!sprint);
    }

    function hide(){

        setShow(false);
    }

    return (
        <Modal show={show} onHide={hide}>
            <Modal.Header closeButton>
                <h3>Add a new race</h3>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group as={Row} className="mb-3">
                        <Form.Label column sm="4">Race Name:</Form.Label>
                        <Col sm="8">
                            <Form.Control type="text"/>
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3">
                        <Form.Label column sm="4">Circuit Name:</Form.Label>
                        <Col sm="8">
                            <Form.Control type="text"/>
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3">
                        <Col>
                            <Form.Check
                                type="switch"
                                id="sprint-switch"
                                label="Sprint Race"
                                onClick={() => toggleSprintRace()}
                            />
                        </Col>
                    </Form.Group>

                    {sprint &&
                        <Form.Group as={Row} className="mb-3">
                            <Form.Label column sm="4">Sprint Race Date:</Form.Label>
                            <Col sm="8">
                                <Form.Control type="datetime-local"/>
                            </Col>
                        </Form.Group>
                    }

                    <Form.Group as={Row} className="mb-3">
                        <Form.Label column sm="4">Race Date:</Form.Label>
                        <Col sm="8">
                            <Form.Control type="datetime-local"/>
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3">
                        <Form.Label column sm="4">Betting Cutoff:</Form.Label>
                        <Col sm="8">
                            <Form.Control type="datetime-local"/>
                        </Col>
                    </Form.Group>
                    <Button type="submit">Save</Button>
                </Form>
            </Modal.Body>
        </Modal>
    )
}

NewRaceModal.propTypes = {
    show: PropTypes.bool,
    setShow: PropTypes.func
}