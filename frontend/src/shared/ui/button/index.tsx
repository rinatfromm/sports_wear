import React from 'react';
import styles from './Button.module.css';

interface ButtonProps {
    className: string;
    title: string;
    onClick?: () => void;
    disabled?: boolean;
    children?: React.ReactNode;
}

const Button: React.FC<ButtonProps> = ({ className, title, onClick, disabled, children }) => {
    return (
        <button className={styles[className]} onClick={onClick} disabled={disabled}>
            {children}
            {title}
        </button>
    );
};

export default Button;