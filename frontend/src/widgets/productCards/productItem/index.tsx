import { useState } from 'react';
import { IProductItems } from '../../../app/types/productItems';
import styles from './ProductItem.module.css'




interface ProductCardProps {
    card: IProductItems;
}

const ProductItem: React.FC<ProductCardProps> = ({ card }) => {

    const [selectedColor, setSelectedColor] = useState<string | null>(null);
    const [selectedSize, setSelectedSize] = useState<string | null>('M');

    return (

        <div className={styles.card}>
            <img src={card.img} alt={card.title} className={styles.cardImg} />
            <h2 className={styles.cardTitle}>{card.title}</h2>
            <p className={styles.cardPrice}>Price: ${card.price}</p>
            <div className={styles.cardColors}>
                <label>Colors:</label>
                <div className={styles.btnsColor}>
                    {card.color.map((color, colorIndex) => (
                        <button
                            key={colorIndex}
                            className={`${styles.colorButton} ${selectedColor === color ? styles.active : ''}`}
                            style={{ backgroundColor: color }}
                            onClick={() => setSelectedColor(color)}
                        >
                        </button>
                    ))}
                </div>
            </div>
            <div className={styles.cardSizes}>
                <label>Sizes:</label>
                <div className={styles.btnsSizes}>
                    {card.sizes.map((size, sizeIndex) => (
                        <button
                            key={sizeIndex}
                            className={`${styles.sizeButton} ${selectedSize === size ? styles.active : ''}`}
                            onClick={() => setSelectedSize(size)}
                        >
                            {size}
                        </button>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default ProductItem