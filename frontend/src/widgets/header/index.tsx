import React, { useState, useEffect } from 'react';
import BasketLogo from './BasketLogo';
import styles from './Header.module.css';

import NavBar from './navbar';
import Button from '../../shared/ui/button';

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
            <div className={styles.headerContainer}>
                <div className={styles.navbar}>
             
                    <NavBar />
                </div>
                <div className={styles.btnsContainer}>
                    <BasketLogo />
                    <Button className={'btns'} title={'Log in'} />
                </div>
            </div>
        </header>
    );
}

export default Header;
