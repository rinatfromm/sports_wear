import { CgAdidas } from "react-icons/cg";
import styles from './LogoHeader.module.css'
import { NavLink } from "react-router-dom";

function LogoHeader() {
    return (
        <NavLink to={'/'} className={styles.navLink}>
                <CgAdidas className={styles.logo} />
        </NavLink>

    )
}

export default LogoHeader