import BasketLogo from '../header/BasketLogo';
import styles from './HeaderOther.module.css';
import NavBar from '../header/navbar';
import Button from '../../shared/ui/button';
import LogoHeader from '../header/logo';
import search from '../../shared/icons/search.svg'

function HeaderOther() {
    return (
        <header className={styles.header} >
            <div className={styles.headerContainer}>
                <div className={styles.navbar}>
                    <LogoHeader />
                    <NavBar containerClass="navBar" />
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

export default HeaderOther