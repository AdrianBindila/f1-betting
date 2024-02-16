import {BasicModal} from "./BasicModal";
import {Modal} from "react-bootstrap";
import PropTypes from "prop-types";

export const UserManagementModal = ({show, setShow}) => {

    function hide() {
        setShow(false);
    }

    return (
        <Modal show={show} onHide={hide}>
            <Modal.Header closeButton>
                <h3>User management modal</h3>
            </Modal.Header>
            <Modal.Body>

            </Modal.Body>
        </Modal>
    )
}

UserManagementModal.propTypes = {
    show: PropTypes.bool, setShow: PropTypes.func
}