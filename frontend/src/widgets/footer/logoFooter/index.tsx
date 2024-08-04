import { NavLink } from "react-router-dom";
import styles from './LogoFooter.module.css'
import logoFooter from '../../../shared/icons/logo_footer.svg'

function LogoFooter() {
    return (
        <NavLink to={'/'} className={styles.navLinkFooter}>
            <img src={logoFooter} alt="Logo" className={styles.logoFooter}/>
        </NavLink>
    )
}

export default LogoFooter