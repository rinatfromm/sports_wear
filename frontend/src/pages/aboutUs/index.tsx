import styles from './AboutUs.module.css'
import about from './../../shared/ assets/  images/about_us.svg'
import { Link } from 'react-router-dom'


function AboutUS() {
  return (
    <article className={styles.aboutUs}>
      <img src={about} alt="About Us" />
      <div className={styles.aboutUsContainer}>
        <h2>From Dreams to Reality</h2>
        <p className={styles.journeyText}>Our journey began in a small garage with nothing but a passion for sports and a dream to empower athletes of all levels. </p>
        <p className={styles.companyDescription}>Founded by a group of sports enthusiasts,SportEgo was born out of a desire to provide high-quality sports gear and apparel that not only meets but exceeds the needs of our customers.</p>
        <Link to="/about" className={styles.contactLink}>mainoffice@sportego.com</Link>
        <div className={styles.contactDetails}>
          <ul className={styles.contactList}>
            <li className={styles.contactItem}>
              <span className={styles.highlight}>Phone</span>
              <span className={styles.contactInfo}>+14 843 593 490</span>
            </li>
            <li className={styles.contactItem}>
              <span className={styles.highlight}>Main office</span>
              <span className={styles.contactInfo}>Kalagari St., 16, Melborn, USA</span>
            </li>
          </ul>
        </div>
        <p className={styles.invitationText}>
          We invite you to become part of our story. Follow us on social media for the latest updates, join our community for tips and support, and shop with us to equip yourself for greatness.
        </p>
        <p className={styles.inspirationalMessage}>
          Together, we can achieve extraordinary things!
        </p>
        <div className={styles.socialLinks}>
          <Link to="/about">Instagram</Link>
          <Link to="/about">Facebook</Link>
          <Link to="/about">LinkedIn</Link>
          <Link to="/about">Youtube</Link>
        </div>
      </div>
    </article>
  )
}

export default AboutUS