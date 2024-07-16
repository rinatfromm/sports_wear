import BasketLogo from '../header/BasketLogo';
import styles from './HeaderOther.module.css';
import LogoHeader from '../header/logo';
import NavBar from '../header/navbar';
import Button from '../../shared/ui/button';

function HeaderOther() {
    return (
        <header className={styles.header} >
            <div className={styles.headerContainer}>
                <div className={styles.navbar}>
                    <LogoHeader />
                    <NavBar />
                </div>
                <div className={styles.btnsContainer}>
                    <div className={styles.authBtns}>
                        <Button className={'btns'} title={'Log in'} />
                        <Button className={'btns'} title={'Sign up'} />
                    </div>
                    <div>
                        <BasketLogo />
                    </div>
                </div>
            </div>
        </header>
    );
}

export default HeaderOther