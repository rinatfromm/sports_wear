import styles from './MainPage.module.css'
import ProductList from '../../entities/Products/ui/productsList';
import Billboard from '../../widgets/billboard';
import FeaturesSection from '../../widgets/featuresSection';
import OurPartners from '../../widgets/ourPartnersSection';
import ProbeCards from '../../widgets/probeCards';


const MainPage: React.FC = () => {
    return (
        <div className={styles.imgContainer}>
            <Billboard />
            <FeaturesSection />
            <ProductList />
            <ProbeCards></ProbeCards>
            <OurPartners />
        </div>
    );
};

export default MainPage;