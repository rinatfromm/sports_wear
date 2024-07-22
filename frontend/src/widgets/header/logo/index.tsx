import logo from '../../../shared/icons/logo.svg'
import styles from './LogoHeader.module.css'
import { NavLink } from "react-router-dom";

function LogoHeader() {
    return (
        <NavLink to={'/'} className={styles.navLink}>
           <img src={logo} alt="Logo" />
        </NavLink>
    )
}

export default LogoHeader