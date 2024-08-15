import BasketLogo from '../header/BasketLogo';
import styles from './HeaderOther.module.css';
import NavBar from '../header/navbar';
import Button from '../../shared/ui/button';
import LogoHeader from '../header/logo';
import SearchBar from '../header/searchBar';
import { useAuth } from '../../shared/hooks/useAuth';
import LoginModal from '../loginModal';

const HeaderOther: React.FC = () => {
    const { isModalOpen, handleLoginClick, handleCloseModal } = useAuth();


    return (
        <header className={styles.header} >
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
                    <Button className={'btns'} title={'Log in'} onClick={handleLoginClick}/>
                </div>
            </div>
            {isModalOpen && <LoginModal onClose={handleCloseModal} />}
        </header>
    );
}

export default HeaderOther