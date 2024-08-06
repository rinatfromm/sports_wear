import styles from './MainPage.module.css'
import ProductList from '../../entities/Products/ui/productsList';
import Billboard from '../../widgets/billboard';
import FeaturesSection from '../../widgets/featuresSection';
import OurPartners from '../../widgets/ourPartnersSection';


const MainPage: React.FC = () => {
    return (
        <div className={styles.imgContainer}>
            <Billboard />
            <FeaturesSection />
            <ProductList />
            <OurPartners />
        </div>
    );
};

export default MainPage;