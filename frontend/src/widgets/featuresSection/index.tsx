import styles from './FeaturesSection.module.css'
import boxing from '../../shared/ assets/  images/box.svg'
import featuresSectionCards from './featuresSectionCards'
import arrowRight from '../../shared/icons/arrow-right.svg'
import arrow from '../../shared/ assets/  images/ arrow.svg'


function FeaturesSection() {
    return (
        <section className={styles.features_section}>
            <div className={styles.description_block}>
                <p className={styles.features}>Features</p>
                <h3 className={styles.features_h3}>The only sportswear you’ll ever need. <span className={styles.highlight}>Simple.</span></h3>
                <p className={styles.features_description}>Spend smarter, lower your bills, get cashback on everything you buy, and unlock credit to grow your business.</p>
            </div>
            <div className={styles.feature_items}>
                <div className={styles.feature_card_container}>
                    {featuresSectionCards.map((card, index) => (
                        <div key={index} className={styles.feature_card}>
                            <div className={styles.feature_card_icons}>
                                <card.icon />
                            </div>
                            <div className={styles.feature_card_content}>
                                <h4 className={styles.feature_title_card}>{card.title}</h4>
                                <p className={styles.features_description_card}>{card.description}</p>
                                <a href={card.link} className={styles.feature_link}>Learn More <img src={arrowRight} alt='arrow_right' /></a>
                            </div>
                        </div>
                    ))}
                </div>
                <div className={styles.boxing_container}>
                    <img src={arrow} alt="Arrow" className={styles.arrow}/>
                    <img src={boxing} alt="Boxing" />
                </div>
            </div>
        </section>
    )
}

export default FeaturesSection