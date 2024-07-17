import styles from './Billboard.module.css'
import sport from '../../shared/ assets/  images/Subheading.svg';
import textSimple from './../../shared/ assets/  images/Heading.svg'
import light from '../../shared/ assets/  images/Light.svg'
import girl from '../../shared/ assets/  images/girl.svg'
import spor from '../../shared/ assets/  images/SPOR.svg'
import tego from '../../shared/ assets/  images/TEGO.svg'

function Billboard() {
    return (
        <section className={styles.main_banner}>
            <img src={light} alt="Light" className={styles.gridient} />
            <div className={styles.main_container}>
                <div className={styles.main_title_container}>
                    <img src={sport} alt="Super,Simple,Sportish" className={styles.main_title_one} />
                    <img src={textSimple} alt="Simple portwear that works like magic" className={styles.main_title_two} />
                </div>
                
                <div className={styles.main_sportego}>
                    <img src={spor} alt="Spor" className={styles.image_one} />
                    <img src={girl} alt="Girl" className={styles.image_two} />
                    <img src={tego} alt="Tego" className={styles.image_three} />
                </div>
                
              
            </div>
        </section>
    )
}

export default Billboard