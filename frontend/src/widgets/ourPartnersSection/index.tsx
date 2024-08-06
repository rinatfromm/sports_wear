import Button from '../../shared/ui/button'
import styles from './OurPartnersSection.module.css'
import partnersLogo from './ourPartnersLogo'

function OurPartners() {
    return (
        <section className={styles.partnersContainer}>
            <div className={styles.contentTitle}>
                <p className={styles.title}>Our partners</p>
                <h3 className={styles.partners_h3}>We operate at full capacity.<span className={styles.highlight}>Brotherhood.</span></h3>
                <p className={styles.welcomeMessage}>Welcome to SportEgo, where your dreams meet our dedication, and together, we make champions.</p>
            </div>
            <div className={styles.contentLogos}>
                {partnersLogo.map((logo, index) => (
                    <div key={index} className={styles.logos}>
                        <logo.logo />
                    </div>
                ))}
            </div>
            <div className={styles.pcontentPartnership}>
                <p className={styles.partnership}>We’re always looking for new partners, challenges and projects.<span className={styles.highlight}> Ready for partnership?</span></p>
                <Button className={"go_to_partnership"} title={'Let’s doing partnership'} />
            </div>

        </section>
    )
}

export default OurPartners