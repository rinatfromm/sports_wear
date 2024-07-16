import BasketLogo from '../header/BasketLogo';
import styles from './HeaderOther.module.css';
import LogoHeader from '../header/logo';
import NavBar from '../header/navbar';

function HeaderOther() {
    return (
        <header className={styles.header} >
            <div className={styles.headerContainer}>
                <div className={styles.navbar}>
                    <LogoHeader />
                    <NavBar />
                </div>
                <div>
                    <BasketLogo />
                </div>
            </div>
        </header>
    );
}

export default HeaderOther