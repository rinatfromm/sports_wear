import React from 'react';
import styles from './ErrorMessage.module.css';

interface ErrorMessageProps {
    message: string;
    className?: string; 
}

const ErrorMessage: React.FC<ErrorMessageProps> = ({ message, className }) => (
    <p className={className ? styles[className] : styles.errorMessage}>
        {message}
    </p>
);

export default ErrorMessage;
