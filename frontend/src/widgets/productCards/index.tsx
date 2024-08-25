import styles from './ProductCards.module.css';
import ProductItem from './productItem';
import { productCards } from '../../shared/utils/productCards'




function ProductCards() {
  return (
    <>
      <div className={styles.classContainer}>
        {productCards.map((card, index) => (
          <ProductItem key={index} card={card} />
        ))}
      </div>
    </>
  );
}

export default ProductCards;





