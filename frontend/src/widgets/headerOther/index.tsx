import BasketLogo from '../header/BasketLogo';
import styles from './HeaderOther.module.css';
import NavBar from '../header/navbar';
import Button from '../../shared/ui/button';

function HeaderOther() {
    return (
        <header className={styles.header} >
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

export default HeaderOther