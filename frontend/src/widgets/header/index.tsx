import BasketLogo from './BasketLogo'
import styles from './Header.module.css'
import LogoHeader from './logo'
import NavBar from './navbar'

const Header: React.FC = () => {
    return (
        <header className={styles.header}>
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

export default Header