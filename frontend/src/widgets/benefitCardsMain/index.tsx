import { NavLink } from 'react-router-dom'
import FlickityCarousel from '../flickityCarousel'
import styles from './benefitCardsMain.module.css'
import CallOut from '../../shared/ assets/  images/CallOut.svg'

function BenefitCardsMain() {
    return (
        <section className={styles.benefitCardsMainContainer}>
            <div className={styles.benefitContent}>
                <h3 className={styles.benefitTitle}>Goods</h3>
                <p className={styles.benefitSlogan}>Choosing us - choose <span className={styles.highlight}>comfort.</span></p>
                <p className={styles.benefitText}>Spend smarter, lower your bills, get cashback on everything you buy, and unlock and unlock your limitless power.</p>
                <img src={CallOut} alt="Call Out" className={styles.callOut} />
                <div >
                    <NavLink to="/allProducts" className={styles.seeAllProducts}>
                        See all products
                        <div className={styles.arrowAllProducts}></div>
                    </NavLink>
                </div>
            </div>
            <FlickityCarousel />
        </section>
    )
}

export default BenefitCardsMain