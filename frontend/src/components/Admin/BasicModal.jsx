import PropTypes from "prop-types";
import {NewRaceModal} from "./NewRaceModal";
import {Button, Col, Form, Modal, Row} from "react-bootstrap";

export function BasicModal({show, setShow, title, body}) {
    function hide() {
        setShow(false);
    }
    return (
        <Modal show={show} onHide={hide}>
            <Modal.Header closeButton>
                <h3>{title}</h3>
            </Modal.Header>
            <Modal.Body>
                {body}
            </Modal.Body>
        </Modal>
    )
}

BasicModal.propTypes = {
    show: PropTypes.bool,
    setShow: PropTypes.func,
    title: PropTypes.string,
    body: PropTypes.node
}
