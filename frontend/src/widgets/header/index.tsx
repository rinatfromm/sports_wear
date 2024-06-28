import styles from '../../app/styles/Header.module.css'
import NavBar from './navbar'

function Header(): JSX.Element {
    return (
        <header className={styles.header}>
            <NavBar />
        </header>
    )
}

export default Header