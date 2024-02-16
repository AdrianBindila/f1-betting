import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import PropTypes from "prop-types";

export function APIFetchModal({show, setShow}) {
    function hide() {
        setShow(false);
    }

    return (
        <Modal show={show} onHide={hide}>
            <Modal.Header closeButton>
                <h3>Ergast API control panel</h3>
            </Modal.Header>
            <Modal.Body>
                    <Button className="m-1">Get Races (2024)</Button>
                    <Button className="m-1">Get Drivers (2023)</Button>
                    <Button className="m-1">Get Standings (2023)</Button>
            </Modal.Body>
        </Modal>
    )
}

APIFetchModal.propTypes = {
    show: PropTypes.bool,
    setShow: PropTypes.func
}