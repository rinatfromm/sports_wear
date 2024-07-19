import styles from './FeaturesSection.module.css'
import boxing from '../../shared/ assets/  images/box.svg'

function FeaturesSection() {
    return (
        <section className={styles.features_section}>
            <div className={styles.description_block}>
                <p className={styles.features}>Features</p>
                <h3 className={styles.features_h3}>The only sportswear you’ll ever need. <span className={styles.highlight}>Simple.</span></h3>
                <p className={styles.features_description}>Spend smarter, lower your bills, get cashback on everything you buy, and unlock credit to grow your business.</p>
            </div>
            <div className={styles.feature_items}>
                <div>

                </div>
                <img src={boxing} alt="Boxing" />
            </div>
        </section>
    )
}

export default FeaturesSection