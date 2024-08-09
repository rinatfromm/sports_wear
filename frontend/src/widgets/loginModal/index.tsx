import styles from './LoginModal.module.css'
import LoginForm from './loginForm'
import modal_img from '../../shared/ assets/  images/modal_img.svg'

function LoginModal() {
    return (
        <div className={styles.modal}>
            <div className={styles.modalContent}>
                <LoginForm />
                <img src={modal_img} alt="Modal Image" className={styles.modalImg}/>
            </div>
        </div>
    )
}

export default LoginModal