import React from 'react';
import { Link } from 'react-router-dom';
import Button from '../../../shared/ui/button';
import styles from './LoginForm.module.css';
import google from '../../../shared/icons/google.svg';

interface LoginFormProps {
    onClose: () => void;
}

const LoginForm: React.FC<LoginFormProps> = ({ onClose }) => {
    return (
        <form className={styles.form}>
            <Button className='formBtn' title='X' onClick={onClose} />
            <div className={styles.formContentContainer}>
                <h3 className={styles.formTitle}>Welcome back</h3>
                <p className={styles.formText}>
                    We are pleased to know that you have decided to continue your sports adventure with us.
                </p>
                <div className={styles.inputContainer}>
                    <div className={styles.inputWrapper}>
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder="Enter your email"
                            required
                        />
                    </div>
                    <div className={styles.inputWrapper}>
                        <label>Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            placeholder="Enter your password"
                            required
                        />
                    </div>
                </div>
                <div className={styles.formBtnsContainer}>
                    <Button className='formBtnContinue' title='Continue' />
                    <Button className='formBtnGoogle' title='Log In with Google' />
                    <img src={google} alt='Google' className={styles.google} />
                </div>
                <span className={styles.toLink}>
                    Don’t have an account? <Link to="/" className={styles.linkSignUp}> Sign Up</Link>
                </span>
            </div>
            <div className={styles.formAddress}>
                <p className={styles.addressLinks}>© 2077 UI. All rights reserved.</p>
                <Link to={'/'} className={styles.addressRight}>mainoffice@sportego.com</Link>
            </div>
        </form>
    );
};

export default LoginForm;

