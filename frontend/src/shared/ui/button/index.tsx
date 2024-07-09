import React from 'react';
import styles from './Button.module.css';

interface ButtonProps {
    className: string;
    title: string;
    onClick?: () => void;
    disabled?: boolean;
}

const Button: React.FC<ButtonProps> = ({ className, title, onClick, disabled }) => {
    return (
        <button className={styles[className]} onClick={onClick} disabled={disabled}>
            {title}
        </button>
    );
};

export default Button;