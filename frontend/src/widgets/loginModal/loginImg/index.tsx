import styles from './LoginImg.module.css'
import girl from '../../../shared/ assets/  images/loginModalImg/girl.svg'
import sportego from '../../../shared/ assets/  images/loginModalImg/SPORTEGO.svg'
import newImg from '../../../shared/ assets/  images/loginModalImg/new.svg'
import newcollection from '../../../shared/ assets/  images/loginModalImg/newcollection.svg'
import star_big from '../../../shared/ assets/  images/loginModalImg/star_big.svg'
import star_small from '../../../shared/ assets/  images/loginModalImg/star_small.svg'
import cloud from '../../../shared/ assets/  images/loginModalImg/cloud.svg'


function LoginImg() {
    return (
        <div className={styles.loginImg}>
            <img src={cloud} alt="Cloud" className={styles.cloud} />
            <div className={styles.imagesContainer}>
                <img src={girl} alt="Girl" className={styles.girl} />
                <img src={newcollection} alt="New Collection" className={styles.newcollection} />
                <img src={sportego} alt="Sportego" className={styles.sportego} />
                <img src={newImg} alt="NewImg" className={styles.newImg} />
                <img src={star_big} alt="Star Big" className={styles.star_big} />
                <img src={star_small} alt="Star Small" className={styles.star_small} />
            </div>
        </div>
    )
}

export default LoginImg