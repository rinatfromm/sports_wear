import styles from './MainPage.module.css'
import ProductList from '../../entities/Products/ui/productsList';
import Billboard from '../../widgets/billboard';
import FeaturesSection from '../../widgets/featuresSection';


const MainPage: React.FC = () => {
    return (
        <div className={styles.imgContainer}>
            <Billboard />
            <FeaturesSection />
            <ProductList />
        </div>
    );
};

export default MainPage;