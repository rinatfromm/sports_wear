import styles from './Header.module.css'
import LogoHeader from './logo'
import NavBar from './navbar'

function Header(): JSX.Element {
    return (
        <header className={styles.header}>
            <LogoHeader />
            <NavBar />
        </header>
    )
}

export default Header