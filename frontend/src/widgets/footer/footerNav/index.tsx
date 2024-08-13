import NavBar from '../../header/navbar'
import styles from './FotterNav.module.css'

function FotterNav() {
    return (
        <div className={styles.footer}>
            <NavBar containerClass="navBar"
                linkClass="link"
                navItemClass="navItem"
                activeLinkClass="activeLink" />
        </div>
    )
}

export default FotterNav