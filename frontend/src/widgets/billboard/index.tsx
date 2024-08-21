import styles from './Billboard.module.css'
import sport from '../../shared/ assets/  images/Subheading.svg';
import textSimple from './../../shared/ assets/  images/Heading.svg'
import light from '../../shared/ assets/  images/Light.svg'
import girl from '../../shared/ assets/  images/girl.svg'
import spor from '../../shared/ assets/  images/SPOR.svg'
import tego from '../../shared/ assets/  images/TEGO.svg'
import Button from '../../shared/ui/button';
import icon from '../../shared/icons/play-circle.svg'
import { NavLink } from 'react-router-dom';

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
                <div className={styles.main_banner_btns}>
                    <Button className={"whatch_our_promo"} title={'Whatch our promo'}>
                        <img src={icon} alt="icon" className={styles.icon_whatch_our_promo} />
                    </Button>
                    <NavLink to="/allProducts" className={"go_to_shopping_btn"}>
                        <Button className={"go_to_shopping"} title={'Go to shopping'}></Button>
                    </NavLink>
                </div>
            </div>
        </section>
    )
}

export default Billboard