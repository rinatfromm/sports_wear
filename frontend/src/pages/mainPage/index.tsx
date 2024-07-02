import sportImage from '../../shared/icons/portrait-of-athletic-male-tennis-player.jpg'
import styles from './MainPage.module.css'
import ProductList from '../../entities/Products/ui/productsList';


const MainPage: React.FC = () => {
    return (
        <div className={styles.imgContainer}>
            <img src={sportImage} alt="sport" className={styles.img} />
            <ProductList />
        </div>
    );
};

export default MainPage;