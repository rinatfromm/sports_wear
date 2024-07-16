import React, { useState, useEffect } from 'react';
import BasketLogo from './BasketLogo';
import styles from './Header.module.css';
import LogoHeader from './logo';
import NavBar from './navbar';

const Header: React.FC = () => {
    const [background, setBackground] = useState('transparent');

    const handleScroll = () => {
        if (window.scrollY > 50) {
            setBackground('#080F21'); 
        } else {
            setBackground('transparent'); 
        }
    };

    useEffect(() => {
        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    return (
        <header className={styles.header} style={{ backgroundColor: background }}>
            <div className={styles.navbar}>
                <LogoHeader />
                <NavBar />
            </div>
            <div>
                <BasketLogo />
            </div>
        </header>
    );
}

export default Header;
