import React, { useState, useEffect } from 'react';
import BasketLogo from './BasketLogo';
import styles from './Header.module.css';
import search from '../../shared/icons/search.svg';
import NavBar from '../header/navbar/index';
import Button from '../../shared/ui/button';
import LogoHeader from '../header/logo/index';
import LoginModal from '../loginModal/index';

const Header: React.FC = () => {
    const [background, setBackground] = useState<string>('transparent');
    const [isModalOpen, setIsModalOpen] = useState<boolean>(false);

    const handleScroll = () => {
        if (window.scrollY > 50) {
            setBackground('#080F21');
        } else {
            setBackground('transparent');
        }
    };

    const handleLoginClick = () => {
        setIsModalOpen(true);
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
    };

    useEffect(() => {
        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    return (
        <>
            <header className={styles.header} style={{ backgroundColor: background }}>
                <div className={styles.headerContainer}>
                    <div className={styles.navbar}>
                        <LogoHeader />
                        <NavBar
                            containerClass="navBar"
                            linkClass="link"
                            navItemClass="navItem"
                            activeLinkClass="activeLink"
                            arrowBottomClass="arrowHeader"
                        />
                    </div>
                    <div className={styles.btnsContainer}>
                        <div className={styles.inputWrapper}>
                            <input type="text" className={styles.search} placeholder="Search" />
                            <img src={search} alt="Search Icon" className={styles.icon} />
                        </div>
                        <BasketLogo />
                        <Button className='btns' title="Log in" onClick={handleLoginClick} />
                    </div>
                </div>
            </header>
            {isModalOpen && <LoginModal onClose={handleCloseModal} />}
        </>
    );
};

export default Header;

