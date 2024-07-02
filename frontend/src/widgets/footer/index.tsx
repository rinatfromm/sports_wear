import { FaLinkedin } from "react-icons/fa"
import { Link } from "react-router-dom"
import styles from './Footer.module.css'

function Footer(): JSX.Element {
    return (
        <footer className={styles.footer}>
            <div className={styles.footerTeamInfo}>
                <p>Frontend Development: Rinat</p>
                <p>Backend Development: Vlad</p>
                <p>Design: Name</p>
            </div>
            <div className={styles.footerLinkContainer}>
                <Link to={'https://www.linkedin.com/in/rinat-fromm-4a457a298/'} target="_blank" rel="noopener noreferrer" className={styles.footerLink}><FaLinkedin /></Link>
                <Link to={'https://www.linkedin.com/in/rinat-fromm-4a457a298/'} target="_blank" rel="noopener noreferrer" className={styles.footerLink}><FaLinkedin /></Link>
                <Link to={'https://www.linkedin.com/in/rinat-fromm-4a457a298/'} target="_blank" rel="noopener noreferrer" className={styles.footerLink}><FaLinkedin /></Link>
            </div>
        </footer >
    )
}

export default Footer