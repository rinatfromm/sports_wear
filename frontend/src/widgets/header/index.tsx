import React, { useState, useEffect } from 'react';
import BasketLogo from './BasketLogo';
import styles from './Header.module.css';
import NavBar from '../header/navbar/index';
import Button from '../../shared/ui/button';
import LogoHeader from '../header/logo/index';
import LoginModal from '../loginModal/index';
import SearchBar from './searchBar';
import { useAuth } from '../../shared/hooks/useAuth';

const Header: React.FC = () => {
    const [background, setBackground] = useState<string>('transparent');
    const { isModalOpen, handleLoginClick, handleCloseModal } = useAuth();

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
                        <SearchBar />
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

