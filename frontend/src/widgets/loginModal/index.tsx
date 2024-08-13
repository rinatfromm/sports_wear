import React from 'react';
import styles from './LoginModal.module.css';
import LoginForm from './loginForm/index';
import modal_img from '../../shared/ assets/  images/modal_img.svg';

interface LoginModalProps {
    onClose: () => void;
}

const LoginModal: React.FC<LoginModalProps> = ({ onClose }) => {
    return (
        <div className={styles.modal}>
            <div className={styles.modalContent}>
                <LoginForm onClose={onClose} />
                <img src={modal_img} alt="Modal Image" className={styles.modalImg} />
            </div>
        </div>
    );
};

export default LoginModal;
