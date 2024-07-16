import styles from './MainPage.module.css'
import ProductList from '../../entities/Products/ui/productsList';
import Billboard from '../../widgets/billboard';


const MainPage: React.FC = () => {
    return (
        <div className={styles.imgContainer}>
            <Billboard />
            <ProductList />
        </div>
    );
};

export default MainPage;