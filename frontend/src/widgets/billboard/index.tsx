import styles from './Billboard.module.css'
import sport from '../../shared/ assets/  images/Subheading.svg';
import textSimple from './../../shared/ assets/  images/Heading.svg'
import light from '../../shared/ assets/  images/Light.svg'

function Billboard() {
    return (
        <section className={styles.main_banner}>
            <img src={light} alt="Light" className={styles.gridient}/>
            <div className={styles.main_container}>
                <div className={styles.main_title_container}>
                    <img src={sport} alt="Super,Simple,Sportish" className={styles.main_title_one} />
                    <img src={textSimple} alt="Simple portwear that works like magic" className={styles.main_title_two} />
                </div>
            </div>
        </section>
    )
}

export default Billboard