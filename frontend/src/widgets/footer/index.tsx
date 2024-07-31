import styles from './Footer.module.css'
import NavBar from '../header/navbar'
import LogoFooter from './logoFooter'
import { Link } from 'react-router-dom'
import Button from '../../shared/ui/button'



function Footer(): JSX.Element {
    return (
        <footer className={styles.footer}>
            <div className={styles.footerContainer}>
                <div className={styles.left}>
                    <LogoFooter />
                    <NavBar
                        containerClass="navBarFooter"
                        linkClass="linkFooter"
                        navItemClass="navItemFooter"
                        activeLinkClass="activeLinkFooter"
                        dropdownToggle='dropdownToggleFooter'
                        arrowImg="arrowImgFooter"
                    />
                </div>
                <div className={styles.right}>
                    <p className={styles.stayInTouch}>Stay in touch</p>
                    <div className={styles.inputEmail}>
                        <input type="email" placeholder='Enter your email'  className={styles.emailFooter} />
                        <Button title='Send' className='sendButton'/>
                    </div>
                </div>
            </div>
            <div className={styles.divider}></div>
            <div className={styles.infoLinkFooter}>
                <p>© 2077 Untitled UI. All rights reserved.</p>
                <div className={styles.linkContainer}>
                    <Link to={'/'} className={styles.linkStyle}>Terms</Link>
                    <Link to={'/'} className={styles.linkStyle}>Privacy</Link>
                    <Link to={'/'} className={styles.linkStyle}>Cookies</Link>
                </div>
            </div>
        </footer >
    )
}

export default Footer