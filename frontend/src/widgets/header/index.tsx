import React, { useState, useEffect } from 'react';
import BasketLogo from './BasketLogo';
import styles from './Header.module.css';
import search from '../../shared/icons/search.svg'
import NavBar from './navbar';
import Button from '../../shared/ui/button';
import LogoHeader from './logo';

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
                    <LogoHeader />
                    <NavBar
                        containerClass="navBar"
                        linkClass="link"
                        navItemClass="navItem"
                        activeLinkClass="activeLink"
                    />
                </div>
                <div className={styles.btnsContainer}>
                    <div className={styles.inputWrapper}>
                        <input type="text" className={styles.search} placeholder="Search" />
                        <img src={search} alt="Search Icon" className={styles.icon} />
                    </div>
                    <BasketLogo />
                    <Button className={'btns'} title={'Log in'} />
                </div>
            </div>
        </header>
    );
}

export default Header;
