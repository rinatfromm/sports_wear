import React from 'react';
import { Product } from '../../model/productTypes';
import styles from './ProductItem.module.css'; // импорт стилей

interface ProductItemProps {
    product: Product;
}

const ProductItem: React.FC<ProductItemProps> = ({ product }) => {
    return (
        <li className={styles.card}>
            <h2 className={styles.title}>{product.title}</h2>
            <p className={styles.description}>{product.description}</p>
            <p className={styles.price}>Price: ${product.price}</p>
            <img src={product.image} alt={product.title} className={styles.image} />
        </li>
    );
};

export default ProductItem;
